package com.sun.book.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.book.domain.Books;
import com.sun.book.service.IBookService;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午2:07:33
 */
@RestController
@RequestMapping("/books")
public class BooksController {

	private static final Logger log = LoggerFactory
			.getLogger(BooksController.class);

	@Reference
	IBookService bookService;

	@GetMapping("/")
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/categories/{id}")
	public List<Books> getBooksByCate(@PathVariable Integer id) {
		return bookService.getBooksByCategories(id);
	}
	
	@PostMapping("/")
	public int saveBook(@ModelAttribute Books books){
		
		return 1;
	}
}
