package com.currency.converter.convert;

public class UserPOJO {

	public UserPOJO() {
		// TODO Auto-generated constructor stub
	}
	
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	String name;
	String age;
	String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserPOJO(int id,String name, String age, String description) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
		this.description = description;
	}
	
	
	
}
