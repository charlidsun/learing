package com.sun.learnMybatisXml.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.learnMybatisXml.domain.Clazz;
import com.sun.learnMybatisXml.service.ClazzService;

@RestController
@RequestMapping("/")
public class ClazzController {

	@Autowired
	ClazzService clazzService;
	
	@GetMapping
	public Clazz getList(int id){
		return clazzService.getListClazz(id);
	}
	
	@GetMapping("/stu")
	public Clazz getStuList(int id){
		return clazzService.getListStuClazz(id);
	}
	
	@GetMapping("/ids")
	public Clazz getStuIdList(@Param("id") int id){
		System.out.println(id);
		return clazzService.getClazzById(id);
	}
}
