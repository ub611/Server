package com.example.petMate.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.command.MyPageAdoptCommand;
import com.example.petMate.command.MyPageBuyCommand;
import com.example.petMate.command.MyPageItemCommand;
import com.example.petMate.command.MyPagePetCommand;
import com.example.petMate.controller.ItemController;
import com.example.petMate.dao.AccountDao;
import com.example.petMate.dao.ItemDao;
import com.example.petMate.dao.mybatis.mapper.ItemMapper;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.Pet;
import com.example.petMate.domain.buy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class PetMateImpl implements PetMateFacade {
	@Autowired
	private ItemDao itemDao;

	private S3FileUploadService s3FileUploadService;

	private static Logger logger1 = LoggerFactory.getLogger(PetMateImpl.class);


	@Autowired
	public PetMateImpl(ItemDao itemDao, S3FileUploadService s3FileUploadService) {
		super();
		this.itemDao = itemDao;
		this.s3FileUploadService = s3FileUploadService;
	}

	@Autowired
	private AccountDao accountDao;

	@Override
	public Account getAccountById(String username) throws DataAccessException{
		// TODO Auto-generated method stub		
		return accountDao.getAccountById(username);
	}

	@Override
	public Account getAccount(String username, String password) throws DataAccessException{
		// TODO Auto-generated method stub
		return accountDao.getAccount(username, password);
	}

	@Override
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
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
		logger1.info("aaa" + items.toString());
		return items;
	}

	@Override
	public Item getItemByItemIdx(int itemIdx) {
		// TODO Auto-generated method stub
		Item item = itemDao.getItemByItemIdx(itemIdx);
		String[] urls = itemDao.getItemImageUrls(itemIdx);
		if(urls.length!=0) {
			item.setIi_url(urls);
		}
		return item;
	}

	@Override
	public Item getItemByItemTitle(String itemTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(ItemCommand itemCommand) throws IOException {
		// TODO Auto-generated method stub
		itemDao.updateItem(itemCommand);
		int i_idx =Integer.valueOf(itemCommand.getI_idx());

		for(MultipartFile url : itemCommand.getIi_url()) {    
			logger1.info("MultipartFile : " + url);
			try {
				itemDao.createItemImage(s3FileUploadService.upload(url, "item"), i_idx);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i_idx;

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
		
		logger1.info("itemCommand : " + itemCommand.toString());
//		logger.info("image urls : " + Arrays.toString(itemCommand.getIi_url()));
		logger1.info("image urls : " + itemCommand.getIi_url());	

		itemDao.createItem(itemCommand);
		int i_idx =Integer.valueOf(itemCommand.getI_idx());
		
		logger1.info("i_idx : " + i_idx);

//		MultipartFile[] urls = itemCommand.getIi_url();
		List<MultipartFile> urls = itemCommand.getIi_url();
		logger1.info("urls : " + urls);

		for(MultipartFile url : itemCommand.getIi_url()) {    
			logger1.info("MultipartFile : " + url);
			itemDao.createItemImage(s3FileUploadService.upload(url, "item"), i_idx);
		}
		return i_idx;
	}

	@Override
	@Transactional
	public int deleteItem(int i_idx) throws IOException {
		// TODO Auto-generated method stub
		itemDao.deleteItemImages(i_idx);
		return itemDao.deleteItem(i_idx);
	}
	
	public List<MyPageItemCommand> getItem(String u_idx) {
		return accountDao.getItem(u_idx);
	}

	@Override
	public List<MyPageBuyCommand> getBuyIamBuyer(String u_idx) {
		// TODO Auto-generated method stub
		return accountDao.getBuyIamBuyer(u_idx);
	}

	@Override
	public List<MyPageAdoptCommand> getIamAdopter(String u_idx) {
		// TODO Auto-generated method stub
		return accountDao.getIamAdopter(u_idx);
	}

	@Override
	public List<MyPagePetCommand> getPet(String u_idx) {
		// TODO Auto-generated method stub
		return accountDao.getPet(u_idx);
	}
}
