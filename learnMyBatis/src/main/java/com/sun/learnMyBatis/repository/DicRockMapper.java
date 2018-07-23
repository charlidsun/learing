package com.sun.learnMyBatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sun.learnMyBatis.domain.DicRock;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 上午9:12:18
 */
@Mapper
public interface DicRockMapper {

	@Insert("INSERT INTO dic_rock (name, net_url, head_img, sort, create_time, title) VALUES ('${name}','${netUrl}','${headImg}',${sort},'${createTime}','${title}')")
	public int insert(DicRock dicRock);

	@Select("select * from dic_rock")
	public List<DicRock> list();
	
	@Select("select * from dic_rock where id= ${id}")
	public DicRock getRock(@Param("id") int id);

	@Delete("delete from dic_rock where id= ${id}")
	public int deleRock(Integer id);
	
}
