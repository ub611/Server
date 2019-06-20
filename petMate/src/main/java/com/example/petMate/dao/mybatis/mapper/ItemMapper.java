package com.example.petMate.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.ItemImage;

//@Mapper
public interface ItemMapper {

	@Select("SELECT * FROM item WHERE i_stock > 0 ORDER BY i_idx DESC")
	List<Item> getItemList();

	@Select("SELECT * FROM item WHERE i_category=#{sort} ORDER BY i_idx DESC")
	List<Item> getItemListBy(int sort);
	
	@Select("SELECT * FROM item WHERE i_idx=#{item_idx} AND i_stock > 0 ORDER BY i_idx DESC")
	Item getItemByItemIdx(int item_idx);

	@Select("SELECT * FROM item WHERE i_title=#{item_title} ")
	Item getItemByItemTitle(String item_title);

	@Update("UPDATE item SET i_title=#{itemCommand.i_title}, i_stock=#{itemCommand.i_stock}, "
			+ "i_price=#{itemCommand.i_price}, i_detail=#{itemCommand.i_detail}, i_category=#{itemCommand.i_category} "
			+ "WHERE i_idx=#{itemCommand.i_idx}")
    @Options(useGeneratedKeys = true, keyProperty = "item.i_idx")
	int updateItem(@Param("itemCommand") ItemCommand item);	
	
	int updateItemStock(Item item_idx, int stock);
	
	List<String> getItemnameList();
	
	@Select("SELECT ii_url FROM item, item_image WHERE item.i_idx = item_image.item_i_idx AND item.i_idx= #{item_idx}")
	String[] getItemImageUrls(int item_idx);
	
    @Insert("INSERT INTO item(i_idx, i_title, i_price, i_stock, i_detail, i_category, user_u_idx, i_date) "
    		+ "VALUES(#{itemCommand.i_idx},#{itemCommand.i_title}, #{itemCommand.i_price},  #{itemCommand.i_stock},"
    		+ " #{itemCommand.i_detail},  #{itemCommand.i_category},  #{itemCommand.user_u_idx},  #{itemCommand.i_date})")
    @Options(useGeneratedKeys = true, keyProperty = "itemCommand.i_idx")
	int createItem(@Param("itemCommand") ItemCommand itemCommand);
	
    @Insert("INSERT INTO item_image(item_i_idx, ii_url) VALUES(#{i_idx}, #{ii_url})")
    int createImages(@Param("ii_url") final String ii_url, @Param("i_idx") final int i_idx);
	
    @Delete("DELETE FROM item WHERE i_idx=#{i_idx}")
    int deleteItem(@Param("i_idx") final int i_idx);
    
    @Delete("DELETE FROM item_image WHERE item_i_idx=#{i_idx}")
    int deleteItemImages(@Param("i_idx") final int i_idx);
    
	
	@Update("UPDATE item SET i_stock=0 WHERE i_idx=#{item_idx}")
	void updateItemByIdx(int item_idx);
	
	@Select("SELECT i_stock FROM item  WHERE i_idx = #{itemId}")
	int getInventoryQuantity(int itemId);

	
}
