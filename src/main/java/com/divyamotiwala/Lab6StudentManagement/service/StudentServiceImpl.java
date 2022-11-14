package com.divyamotiwala.Lab6StudentManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyamotiwala.Lab6StudentManagement.model.Student;
import com.divyamotiwala.Lab6StudentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> fetchAllStudents()
	{
		return new ArrayList<> (this.studentRepository.findAll());
	}
	
	@Override
	public Student savestudent(Student student)
	{
		return this.studentRepository.save(student);
	}
	
	@Override
	public Student fetchStudentById(int studentId)
	{
		Optional<Student> student = this.studentRepository.findById(studentId);
		if(student.isPresent())
			return student.get();
		else
			return null;
	}

	@Override
	public void deleteStudentById(int studentId) {
		Student student = fetchStudentById(studentId);
		if(student != null)
			this.studentRepository.deleteById(studentId);
		
	}

	@Override
	public Student updatestudent(Student student) {
		Student existingStudent = fetchStudentById(student.getStudentId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setCountry(student.getCountry());
		
		return this.studentRepository.save(existingStudent);
	}
}
