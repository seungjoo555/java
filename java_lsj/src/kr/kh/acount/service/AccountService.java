package kr.kh.acount.service;

import java.util.List;

import kr.kh.acount.model.vo.Category;
import kr.kh.acount.model.vo.Item;
import kr.kh.acount.model.vo.Type;

public interface AccountService {

	List<Type> getTypeList();

	List<Category> getCategoryList(String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	boolean updateItem(Item item);

	boolean deleteItem(int it_num);

}
