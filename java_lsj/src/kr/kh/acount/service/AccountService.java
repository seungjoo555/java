package kr.kh.acount.service;

import java.util.List;

import kr.kh.acount.model.vo.Category;
import kr.kh.acount.model.vo.Item;
import kr.kh.acount.model.vo.Type;
import kr.kh.acount.pagination.Criteria;

public interface AccountService {

	List<Type> getTypeList();

	List<Category> getCategoryList(String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	List<Item> getItemListByDate(Criteria cri);
	
	boolean updateItem(Item item);

	boolean deleteItem(int it_num);
	
}
