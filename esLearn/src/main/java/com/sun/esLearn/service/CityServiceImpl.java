package com.sun.esLearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.esLearn.dao.CityDao;
import com.sun.esLearn.entity.City;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月20日 下午6:19:29
 */
@Service
public class CityServiceImpl implements CityService {

	private static final Integer pageNumber = 0;
	private static final Integer pageSize = 10;
	Pageable pageable = new PageRequest(pageNumber, pageSize);

	private CityDao cityDao;
	
	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public Long saveCity(City city) {
		City cityResult = cityDao.save(city);
		return cityResult.getId();
	}

	public List<City> findByDescriptionAndScore(String description,
			Integer score) {
		return cityDao.findByDescriptionAndScore(description, score);
	}

	public List<City> findByDescriptionOrScore(String description, Integer score) {
		return cityDao.findByDescriptionOrScore(description, score);
	}

	public List<City> findByDescription(String description) {
		return cityDao.findByDescription(description, pageable)
				.getContent();
	}

	public List<City> findByDescriptionNot(String description) {
		return cityDao.findByDescriptionNot(description, pageable)
				.getContent();
	}

	public List<City> findByDescriptionLike(String description) {
		return cityDao.findByDescriptionLike(description, pageable)
				.getContent();
	}

}
