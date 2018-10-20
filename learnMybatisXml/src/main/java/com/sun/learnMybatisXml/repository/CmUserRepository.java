package com.sun.learnMybatisXml.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sun.learnMybatisXml.domain.CmUser;

@Repository
@Mapper
public interface CmUserRepository {

	List<CmUser> listCmUser();
	
	CmUser getCmUser(int id);
	
	int updateCmUser(CmUser cmUser);
	
	int deleteCmUser(@Param(value="id") int id);

	int insertCmUser(CmUser cmUser);
}
