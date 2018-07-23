package com.sun.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sun.book.domain.Books;


/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午1:32:09
 */
@Mapper
public interface BooksMapper{
	
	@Select({
		 "<script>",
		 	"SELECT bo.* FROM dic_book bo LEFT JOIN rel_book_categories bo_ca ON bo_ca.book_id = bo.id  where bo.lock=0 ",
		 	"<when test='categoriesId != 0'>",
	 	 		"and bo_ca.categories_id =${categoriesId}",
	 	 	"</when>",
	 	 "</script>"})
	public List<Books> getBooksByCategories(@Param("categoriesId") int categoriesId);

	@Select("select bo.* form dic_book bo where bo.id=${id}")
	public Books getBooksById(@Param("id") Integer id);
}
