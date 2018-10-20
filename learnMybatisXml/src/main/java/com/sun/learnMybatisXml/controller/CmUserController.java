package com.sun.learnMybatisXml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.learnMybatisXml.domain.CmUser;
import com.sun.learnMybatisXml.service.CmUserService;

@RestController
@RequestMapping("/user")
public class CmUserController {

	@Autowired
	CmUserService cmUserService;

	@GetMapping
	public List<CmUser> listUser() {
		return cmUserService.listCmUser();
	}

	@GetMapping("/{id}")
	public CmUser getUser(@PathVariable(value = "id") int id) {
		return cmUserService.getCmUser(id);
	}

	@PutMapping("/user")
	public int insertUser(@RequestBody CmUser cmUser) {
		System.out.println(cmUser.toString());
		return cmUserService.insertCmUser(cmUser);
	}
	
	@DeleteMapping("/{id}")
	public int deleteUser(@PathVariable(value = "id") int id) {
		System.out.println(id);
		return cmUserService.deleteCmUser(id);
	}
	
	@PostMapping
	public int deleteUser(@RequestBody CmUser cmUser) {
		System.out.println(cmUser.toString());
		return cmUserService.updateCmUser(cmUser);
	}

}
