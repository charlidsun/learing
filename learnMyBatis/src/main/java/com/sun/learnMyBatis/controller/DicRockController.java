package com.sun.learnMyBatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.learnMyBatis.domain.DicRock;
import com.sun.learnMyBatis.service.DicRockService;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 上午9:40:10
 */
@RestController
@RequestMapping("/rock")
public class DicRockController {

	@Autowired
	DicRockService dicRockService;
	
	@PostMapping("/")
	public int save(@ModelAttribute DicRock dicRock){
		dicRock.setCreateTime("2018-07-23 09:24:46");
		return dicRockService.save(dicRock);
	}
	
	@GetMapping("/")
	public List<DicRock> list(){
		return dicRockService.list();
	}
	
	@GetMapping("/{id}")
	public DicRock getRock(@PathVariable Integer id){
		return dicRockService.getRock(id);
	}
	
	@DeleteMapping("/{id}")
	public int dele(@PathVariable Integer id){
		return dicRockService.deleRock(id);
	}
}
