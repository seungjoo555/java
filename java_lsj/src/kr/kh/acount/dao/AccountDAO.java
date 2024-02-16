package kr.kh.acount.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.acount.model.vo.Category;
import kr.kh.acount.model.vo.Item;
import kr.kh.acount.model.vo.Type;
import kr.kh.acount.pagination.Criteria;

public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(@Param("ty_name")String type);

	boolean insertItem(@Param("item")Item item);

	List<Item> selectItemListByDate(@Param("it_date")String date);

	List<Item> selectItemListSearch(@Param("cri")Criteria cri);

	boolean updateItem(@Param("item")Item item);
	
	boolean deleteItem(@Param("it_num")int it_num);
}
