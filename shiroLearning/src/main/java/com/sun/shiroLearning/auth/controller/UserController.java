package com.sun.shiroLearning.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.shiroLearning.auth.entity.SysRole;
import com.sun.shiroLearning.auth.service.UserInfoService;
import com.sun.shiroLearning.exception.CustomException;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午9:45:29
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserInfoService userService;

	@GetMapping
	public String get() {
		return "get.....";
	}

	/**
	 * RequiresRoles 是所需角色 包含 AND 和 OR 两种 RequiresPermissions 是所需权限 包含 AND 和 OR
	 * 两种
	 *
	 * @return msg
	 */
	@RequiresRoles(value = {"admin"}, logical = Logical.OR)
	//@RequiresPermissions(value = {"user:list", "user:query"}, logical=Logical.OR)
	@GetMapping("/query")
	public String query(Integer a) {
		if (a == null){
			throw new CustomException(1,"SDDSD");
		}
		System.out.println(a);
		try {
			int res = 10/a;
			System.out.println(res);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return "query.....";
	}

	@GetMapping("/find")
	public String find() {
		return "find.....";
	}

	@PostMapping("/sysRole")
	public List<SysRole> listSysRole(){
		List<SysRole> list = userService.querySysRole("");
		return list;
	}
	
	@PostMapping("/saveOrUpdateRole")
	public String saveOrUpdateRole(Integer id,String role,String description){
		Map<String,Object> map = new HashMap<>();
		map.put("id", id !=null ? id : "");
		map.put("role", role);
		map.put("description", description);
		map.put("available", 1);
		userService.saveOrUpdateRole(map);
		return "success";
	}
	
}
