package com.StudentSubject_ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student1 {
	@Id
	private int id;
	private String name;

	@ManyToMany
	private List<Subject> subjects;

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", subjects=" + subjects + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student1(int id, String name, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}

	public Student1() {

	}

}
