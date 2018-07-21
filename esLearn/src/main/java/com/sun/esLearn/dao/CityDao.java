package com.sun.esLearn.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.sun.esLearn.entity.City;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 下午6:01:08
 */
@Repository
public interface CityDao extends ElasticsearchCrudRepository<City, Long>{

    List<City> findByDescriptionAndScore(String description, Integer score);
    
    List<City> findByDescriptionOrScore(String description,Integer score);
    
    Page<City> findByDescription(String description, Pageable page);
    
    Page<City> findByDescriptionNot(String description, Pageable page);

    Page<City> findByDescriptionLike(String description, Pageable page);
    

}
