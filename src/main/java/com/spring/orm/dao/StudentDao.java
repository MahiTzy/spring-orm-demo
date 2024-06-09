package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public Student getStudent(int sid) {
		Student student = this.hibernateTemplate.get(Student.class, sid);
		return student;
	}
	
	public List<Student> getAllStudent() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	@Transactional
	public void delStudent(int sid) {
		Student student = this.hibernateTemplate.get(Student.class,sid);
		this.hibernateTemplate.delete(student);
	}
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
}
