package com.example.petMate.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.dao.ItemDao;
import com.example.petMate.dao.mybatis.mapper.ItemMapper;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.Item;

@Service
@Transactional
public class PetMateImpl implements PetMateFacade {
	@Autowired
	private ItemDao itemDao;
	
    private S3FileUploadService s3FileUploadService;
	
    @Autowired
	public PetMateImpl(ItemDao itemDao, S3FileUploadService s3FileUploadService) {
		super();
		this.itemDao = itemDao;
		this.s3FileUploadService = s3FileUploadService;
	}

	private static Logger logger = LoggerFactory.getLogger(PetMateImpl.class);

	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getUsernameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemList(int sort) {
		// TODO Auto-generated method stub
		List<Item> items;
		if(sort == 0){
			items = itemDao.getAllItemList();
		}else{
			items = itemDao.getItemListByCategory(sort);
		}
		for(Item t : items) {
			String[] urls = itemDao.getItemImageUrls(t.getI_idx());
			t.setIi_url(urls);
		}
		logger.info("aaa" + items.toString());
		return items;
	}

	@Override
	public Item getItemByItemIdx(int itemIdx) {
		// TODO Auto-generated method stub
		Item item = itemDao.getItemByItemIdx(itemIdx);
		String[] urls = itemDao.getItemImageUrls(itemIdx);
		item.setIi_url(urls);
		return item;
	}

	@Override
	public Item getItemByItemTitle(String itemTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItem(Item itemIdx, Item Item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getItemnameList() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	@Override
	@Transactional
	public int createItem(ItemCommand itemCommand) throws IOException {
		// 아이템 디비 저장 및 아이템 이미지 디비 저장
		// TODO Auto-generated method stub
        
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        itemCommand.setI_date(date);
        int i_idx = itemDao.createItem(itemCommand);
        
        if (itemCommand.getIi_url() != null) {
        	for(MultipartFile url : itemCommand.getIi_url()) {            
    			itemDao.createItemImage(s3FileUploadService.upload(url, "item"), i_idx);
            }
        }


		return i_idx;
	}

}
