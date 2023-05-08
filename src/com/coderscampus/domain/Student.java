package com.coderscampus.domain;

import java.time.LocalDate;

public class Student {
	private Integer id;
	private String name;
	private LocalDate birthdate;
	
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
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
}
