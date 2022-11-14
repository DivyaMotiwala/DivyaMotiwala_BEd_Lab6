package com.divyamotiwala.Lab6StudentManagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.divyamotiwala.Lab6StudentManagement.model.Student;
import com.divyamotiwala.Lab6StudentManagement.service.StudentService;

@Controller
@RequestMapping("/students/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String getStudentsList(Model model)
	{
		model.addAttribute("Students", this.studentService.fetchAllStudents());
		return "list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addStudent(Model model)
	{
		Student student = new Student();
		model.addAttribute("Students", student);
		return "form-student";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String updateStudent(@RequestParam("studentId") int studentId, Model model)
	{
		Student student = this.studentService.fetchStudentById(studentId);
		model.addAttribute("Students", student);
		return "form-student";
	}
	
	@PostMapping("/save")
	public String saveStudent(
							  @RequestParam("firstname") String firstName,
							  @RequestParam("lastname") String lastName,
							  @RequestParam("course") String course,
							  @RequestParam("country") String country,
							  @RequestParam("studentId") int studentId
							 )
	{
		Student student;
		if(studentId != 0)
			student = this.studentService.fetchStudentById(studentId);
		else
			student= new Student();
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);
		this.studentService.savestudent(student);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String getStudentsList(@RequestParam("studentId") int studentId, Model model)
	{
		this.studentService.deleteStudentById(studentId);
		return "redirect:/students/list";
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView model = new ModelAndView();
		
		if(user != null)
			model.addObject("msg", "Hi "+ user.getName()
			+ ", you do not have permission to access this page!");
		else
			model.addObject("msg", "You do not have permission to access this page!");
		
		model.setViewName("403");
		return model;
	}
}
