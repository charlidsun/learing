package com.sun.learnMyBatis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.learnMyBatis.domain.DicRock;
import com.sun.learnMyBatis.repository.DicRockMapper;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 上午9:32:29
 */
@Service
public class DicRockService {

	@Autowired
	DicRockMapper dicRockMapper;
	
	public int save(DicRock dicRock){
		return dicRockMapper.insert(dicRock);
	}

	public List<DicRock> list() {
		return dicRockMapper.list();
	}


	public DicRock getRock(int id) {
		return dicRockMapper.getRock(id);
	}

	@Transactional
	public int deleRock(Integer id) {
		return dicRockMapper.deleRock(id);
	}
}
