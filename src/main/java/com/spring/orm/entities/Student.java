package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	@Id
	@Column(name="student_id")
	private int sid;
	@Column(name="student_name")
	private String name;
	@Column(name="student_city")
	private String city;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String name, String city) {
		super();
		this.sid = sid;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", city=" + city + "]";
	}
	
}
