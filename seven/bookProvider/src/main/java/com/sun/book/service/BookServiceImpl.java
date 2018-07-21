package com.sun.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.book.domain.Books;
import com.sun.common.utils.TransUtils;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午1:28:15
 */
/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午1:28:15
 */
@Service(interfaceClass = IBookService.class)
@Component
public class BookServiceImpl implements IBookService {

	@Autowired
	JdbcTemplate jdbcTemp;

	@Override
	public List<Books> getBooksByCategories(int categoriesId) {
		List<Map<String, Object>> ma = jdbcTemp
				.queryForList("SELECT bo.* FROM dic_book bo LEFT JOIN rel_book_categories bo_ca ON bo_ca.book_id = bo.id where bo_ca.categories_id = "+categoriesId+" and bo.lock = 0");
		List<Books> list = new ArrayList<Books>();
		try {
			list = TransUtils.listMapToList(ma,Books.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public List<Books> getAllBooks() {
		List<Map<String, Object>> ma = jdbcTemp
				.queryForList("SELECT bo.* FROM dic_book bo");
		List<Books> list = new ArrayList<Books>();
		try {
			list = TransUtils.listMapToList(ma,Books.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
