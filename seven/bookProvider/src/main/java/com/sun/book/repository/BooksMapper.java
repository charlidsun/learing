package com.sun.book.repository;

import java.util.List;

import com.sun.book.domain.Books;


/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午1:32:09
 */
public interface BooksMapper{
	
	 //@Select("SELECT bo.*,ca.name FROM dic_book bo LEFT JOIN rel_book_categories bo_ca ON bo_ca.book_id = bo.id LEFT JOIN dic_categories ca ON ca.id = bo_ca.categories_id")
	 public List<Books> getBooksByCategories(int categoriesId);
}
