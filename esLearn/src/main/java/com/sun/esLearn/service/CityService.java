package com.sun.esLearn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sun.esLearn.entity.City;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月20日 下午6:11:31
 */

public interface CityService {

	Long saveCity(City city);

	List<City> findByDescriptionAndScore(String description, Integer score);

	List<City> findByDescriptionOrScore(String description, Integer score);

	List<City> findByDescription(String description);

	List<City> findByDescriptionNot(String description);

	List<City> findByDescriptionLike(String description);
}
