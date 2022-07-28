package com.yuki.monster.Controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yuki.monster.entity.Student;
import com.yuki.monster.service.StudentService;

@Controller
public class StudentControllor {

	private StudentService StudentService;

	public StudentControllor(com.yuki.monster.service.StudentService studentService) {
		super();
		StudentService = studentService;
	}

	// handler method to handle list students request and retuen model and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", StudentService.getAllStudents());
		return "students";

	}

	@GetMapping("/students/new")
	public String createStudentFrom(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);

		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		StudentService.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", StudentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("students") Student student, Model model) {
		
		//get student from database id
		Student existingStudent = StudentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		StudentService.updateStudent(existingStudent);
		return "redirect:/students";
		

	}
	
	//handler method to handle delete student request
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable (value = "id") long id)
	{
		StudentService.deleteStudentById(id);
		return "redirect:/students";
		
		
	}
	
}
