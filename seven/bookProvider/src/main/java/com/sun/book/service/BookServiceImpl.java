package com.sun.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.book.domain.Books;
import com.sun.book.repository.BooksMapper;
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
	BooksMapper booksMapper;

	@Override
	public List<Books> getBooksByCategories(int categoriesId) {
		return booksMapper.getBooksByCategories(categoriesId);
	}

	@Override
	public Books getBooksById(Integer id) {
		return booksMapper.getBooksById(id);
	}

}
