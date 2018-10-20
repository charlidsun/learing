package com.sun.learnMybatisXml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sun.learnMybatisXml.domain.CmUser;
import com.sun.learnMybatisXml.repository.CmUserRepository;

@Service
@CacheConfig(cacheNames="cmUserCache") // 本类内方法指定使用缓存时，默认的名称就是userCache
public class CmUserService {
	
	@Autowired
	CmUserRepository cmUserRepository;

	@Cacheable // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
	public List<CmUser> listCmUser(){
		System.err.println("数据库查询");
		return cmUserRepository.listCmUser();
	};
	
	@Cacheable(key="#p0")// @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
	public CmUser getCmUser(int id) {
		return cmUserRepository.getCmUser(id);
	};
	
	@CachePut(key="#p0.id")
	public int updateCmUser(CmUser cmUser) {
		return cmUserRepository.updateCmUser(cmUser);
	};
	
	@CacheEvict(key="#p0")  //删除缓存名称为userCache,key等于指定的id对应的缓存
	public int deleteCmUser(int id) {
		return cmUserRepository.deleteCmUser(id);
	};
	
	@CachePut(key="#p0.id")  //#p0表示第一个参数
	public int insertCmUser(CmUser cmUser) {
		System.out.println(cmUser);
		return cmUserRepository.insertCmUser(cmUser);
	}
}
