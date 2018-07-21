package com.sun.book.service;

import java.util.List;

import com.sun.book.domain.Books;

/**
 * 功能：
 * 说明：
 * @author sjg:
 * @Date 2018年7月21日 上午10:44:28
 */
public interface IBookService {

	//根据分类查询书籍信息
	public List<Books> getBooksByCategories(int categoriesId);

	//获取所有的书籍
	public List<Books> getAllBooks();
	
}
