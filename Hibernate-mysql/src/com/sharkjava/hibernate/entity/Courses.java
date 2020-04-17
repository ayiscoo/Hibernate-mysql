package com.sharkjava.hibernate.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Courses {
	// this is bidirectional tutorial Many to one class
    // declare parameters
	// load getters and setters
	//load constructors
	// add annotations 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructorCourse;
	
	@OneToMany(mappedBy="course_stud_Object",
			  cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Student> studentList;
    
		
    public Courses() {
		
	}

	public Courses(String title) {
		
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Instructor getInstructorCourse() {
		return instructorCourse;
	}

	public void setInstructorCourse(Instructor instructorCourse) {
		this.instructorCourse = instructorCourse;
	}

	@Override
	public String toString() {
		return "Courses [title=" + title + "]";
	}

	
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void add_students(Student student){
		if (student == null){
			studentList = new ArrayList<Student>();
			studentList.add(student);
		}
		student.setCourse_stud_Object(this);
	}
	
	
	
}
