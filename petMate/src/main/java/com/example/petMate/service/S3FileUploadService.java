package com.example.petMate.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class S3FileUploadService {

    // 버킷 이름 동적 할당
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    // 버킷 주소 동적 할당
    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;


    private AmazonS3Client amazonS3Client = AmazonS3Client();
    
    @Autowired
    public S3FileUploadService(final AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }
    
    @Bean
    public static AmazonS3Client AmazonS3Client() {
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
        		.withRegion("ap-northeast-2")
        		.withForceGlobalBucketAccessEnabled(true)
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }
    

    public String upload(MultipartFile uploadFile, String folder) throws IOException {
        String origName = uploadFile.getOriginalFilename();
        String url;
        try {
            //확장자
            final String ext = origName.substring(origName.lastIndexOf('.'));
            //파일이름 암호화
            final String saveFileName = getUuid() + ext;
            //파일 객체 생성
            File file = new File(System.getProperty("user.dir") + saveFileName);
            //파일 변환
            uploadFile.transferTo(file);
            //S3 파일 업로드
            uploadOnS3(saveFileName, file, folder);
            //주소 할당
            url = defaultUrl + folder + "/"+ saveFileName;
            //파일 삭제
            file.delete();
        }catch (Exception e) {
            e.printStackTrace();
            //파일이 없을 경우 예외 처리
            url = null;
        }
        return url;
    }

    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //S3에 파일을 업로드한다.
    private void uploadOnS3(final String fileName, final File file, String folder) {
        //AWS S3 전송 객체 생성
        final TransferManager transferManager = new TransferManager(this.amazonS3Client);
        // 버킷 url 설정
        String bucketUrl = bucket + "/"+folder;
        //요청 객체 생성
        final PutObjectRequest request = new PutObjectRequest(bucketUrl, fileName, file);
        //업로드 시도
        final Upload upload = transferManager.upload(request);

        try {
            //완료 확인
            upload.waitForCompletion();
        } catch (AmazonClientException amazonClientException) {
        } catch (InterruptedException e) {
        }
    }
}
