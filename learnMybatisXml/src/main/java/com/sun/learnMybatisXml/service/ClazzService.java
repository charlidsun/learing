package com.sun.learnMybatisXml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.learnMybatisXml.domain.Clazz;
import com.sun.learnMybatisXml.repository.ClazzRepository;

@Service
public class ClazzService {

	@Autowired
	ClazzRepository clazzRepository;
	
	public Clazz getListClazz(int id){
		return clazzRepository.getClazz(id);
	}
	
	public Clazz getListStuClazz(int id){
		return clazzRepository.getClazzStu(id);
	}
	
	public Clazz getClazzById(Integer id){
		return clazzRepository.getClazzById(id);
	}
}
