package com.sun.esLearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.esLearn.entity.City;
import com.sun.esLearn.service.CityService;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月20日 下午6:26:58
 */
@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	/**
	 * 插入 ES 新城市
	 *
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/api/city", method = RequestMethod.POST)
	public Long createCity(@RequestBody City city) {
		return cityService.saveCity(city);
	}

	/**
	 * AND 语句查询
	 *
	 * @param description
	 * @param score
	 * @return
	 */
	@RequestMapping(value = "/api/city/and/find", method = RequestMethod.GET)
	public List<City> findByDescriptionAndScore(
			@RequestParam(value = "description") String description,
			@RequestParam(value = "score") Integer score) {
		return cityService.findByDescriptionAndScore(description, score);
	}

	/**
	 * OR 语句查询
	 *
	 * @param description
	 * @param score
	 * @return
	 */
	@RequestMapping(value = "/api/city/or/find", method = RequestMethod.GET)
	public List<City> findByDescriptionOrScore(
			@RequestParam(value = "description") String description,
			@RequestParam(value = "score") Integer score) {
		return cityService.findByDescriptionOrScore(description, score);
	}

	/**
	 * 查询城市描述
	 *
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/api/city/description/find", method = RequestMethod.GET)
	public List<City> findByDescription(
			@RequestParam(value = "description") String description) {
		return cityService.findByDescription(description);
	}

	/**
	 * NOT 语句查询
	 *
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/api/city/description/not/find", method = RequestMethod.GET)
	public List<City> findByDescriptionNot(
			@RequestParam(value = "description") String description) {
		return cityService.findByDescriptionNot(description);
	}

	/**
	 * LIKE 语句查询
	 *
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/api/city/like/find", method = RequestMethod.GET)
	public List<City> findByDescriptionLike(
			@RequestParam(value = "description") String description) {
		return cityService.findByDescriptionLike(description);
	}
}
