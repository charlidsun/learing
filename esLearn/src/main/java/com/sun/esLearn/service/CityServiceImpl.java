package com.sun.esLearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.esLearn.entity.City;
import com.sun.esLearn.repository.CityRepository;

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
	@SuppressWarnings("deprecation")
	Pageable pageable = new PageRequest(pageNumber, pageSize);

	@Autowired
	CityRepository cityRepository;

	public Long saveCity(City city) {
		City cityResult = cityRepository.save(city);
		return cityResult.getId();
	}

	public List<City> findByDescriptionAndScore(String description,
			Integer score) {
		return cityRepository.findByDescriptionAndScore(description, score);
	}

	public List<City> findByDescriptionOrScore(String description, Integer score) {
		return cityRepository.findByDescriptionOrScore(description, score);
	}

	public List<City> findByDescription(String description) {
		return cityRepository.findByDescription(description, pageable)
				.getContent();
	}

	public List<City> findByDescriptionNot(String description) {
		return cityRepository.findByDescriptionNot(description, pageable)
				.getContent();
	}

	public List<City> findByDescriptionLike(String description) {
		return cityRepository.findByDescriptionLike(description, pageable)
				.getContent();
	}

}
