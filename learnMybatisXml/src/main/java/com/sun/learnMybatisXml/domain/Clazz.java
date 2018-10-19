package com.sun.learnMybatisXml.domain;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Teacher teacher;
	private List<Student> listStudent;
	
	public Clazz() {
	}
	
	public Clazz(Integer id, String name, Teacher teacher,List<Student> listStudent) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.listStudent = listStudent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
}
