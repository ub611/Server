package com.example.petMate.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.ItemImage;

//@Mapper
public interface ItemMapper {

	@Select("SELECT * FROM item ORDER BY i_date")
	List<Item> getItemList();

	@Select("SELECT * FROM item WHERE i_category=#{sort} ORDER BY i_date")
	List<Item> getItemListBy(int sort);
	
	@Select("SELECT * FROM item WHERE i_idx=#{item_idx}")
	Item getItemByItemIdx(int item_idx);

	@Select("SELECT * FROM item WHERE i_title=#{item_title}")
	Item getItemByItemTitle(String item_title);

	int updateItem(Item item_idx, Item Item);
	
	
	int updateItemStock(Item item_idx, int stock);
	

	List<String> getItemnameList();
	
	@Select("SELECT ii_url FROM item, item_image WHERE item.i_idx = item_image.item_i_idx AND item.i_idx= #{item_idx}")
	String[] getItemImageUrls(int item_idx);
	
    @Insert("INSERT INTO item(i_title, i_price, i_stock, i_detail, i_category, user_u_idx, i_date) "
    		+ "VALUES(#{itemCommand.i_title}, #{itemCommand.i_price},  #{itemCommand.i_stock},"
    		+ " #{itemCommand.i_detail},  #{itemCommand.i_category},  #{itemCommand.user_u_idx},  #{itemCommand.i_date})")
	int createItem(ItemCommand itemCommand);
	
    @Insert("INSERT INTO itemImage(item_i_idx, ii_url) VALUES(#{i_idx}, #{ii_url})")
    int createImages(@Param("ii_url") final String ii_url, @Param("i_idx") final int i_idx);

}
