package com.emily.domain;

public class User {
	private int id;
	private String name;
	private String email;
	private int grade;
	private String pwd;
	
	
	public User(int id, String name, String email, int grade, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.grade = grade;
		this.pwd = pwd;
	}
	
	public User(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
