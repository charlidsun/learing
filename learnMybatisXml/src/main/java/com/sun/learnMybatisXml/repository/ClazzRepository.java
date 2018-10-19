package com.sun.learnMybatisXml.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sun.learnMybatisXml.domain.Clazz;

@Mapper
@Repository
public interface ClazzRepository {

	public Clazz getClazz(int id);
	
	public Clazz getClazzStu(int id);
	
	public Clazz getClazzById(@Param(value="id") Integer id);
	
}
