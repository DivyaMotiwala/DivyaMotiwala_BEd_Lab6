package com.divyamotiwala.Lab6StudentManagement.service;

import java.util.List;

import com.divyamotiwala.Lab6StudentManagement.model.Student;

public interface StudentService {

	public List<Student> fetchAllStudents();
	public Student savestudent(Student student);
	public Student fetchStudentById(int studentId);
	public void deleteStudentById(int studentId);
	public Student updatestudent(Student student);
}
