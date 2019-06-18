package com.example.petMate.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.dao.ItemDao;
import com.example.petMate.dao.mybatis.mapper.ItemMapper;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.ItemImage;

@Repository
public class MybatisItemDao implements ItemDao{
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> getAllItemList() {
		// TODO Auto-generated method stub
		return itemMapper.getItemList();
	}
	@Override
	public List<Item> getItemListByCategory(int sort) {
		// TODO Auto-generated method stub
		return itemMapper.getItemListBy(sort);
	}

	@Override
	public Item getItemByItemIdx(int item_idx) {
		// TODO Auto-generated method stub
		return itemMapper.getItemByItemIdx(item_idx);
	}

	@Override
	public Item getItemByItemTitle(String item_title) {
		// TODO Auto-generated method stub
		return itemMapper.getItemByItemTitle(item_title);
	}

	@Override
	public int updateItem(Item item_idx, Item Item) {
		// TODO Auto-generated method stub
		return itemMapper.updateItem(item_idx, Item);
		
	}
	
	@Override
	public int updateItemStock(Item item_idx, int Stock) {
		// TODO Auto-generated method stub
		return itemMapper.updateItemStock(item_idx, Stock);

	}
	
	@Override
	public List<String> getItemnameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getItemImageUrls(int item_idx ){
		// TODO Auto-generated method stub
		return itemMapper.getItemImageUrls(item_idx);
	}
	@Override
	public int createItem(ItemCommand itemCommand) {
		// TODO Auto-generated method stub
		return itemMapper.createItem(itemCommand);
	}
	@Override
	public int createItemImage(String ii_url, int i_idx) {
		// TODO Auto-generated method stu
		return itemMapper.createImages(ii_url, i_idx);
	}
}
