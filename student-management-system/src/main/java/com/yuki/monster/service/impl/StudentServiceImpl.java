package com.yuki.monster.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yuki.monster.entity.Student;
import com.yuki.monster.repository.StudentRepository;
import com.yuki.monster.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
//we  can also @autowired it anotation
	private StudentRepository studentRepository;
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}



	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}



	@Override
	public Student updateStudent(Student student) {
			
		return studentRepository.save(student);
	}



	@Override
	public Student getStudentById(Long id) {
		
	
		return studentRepository.findById(id).get();
	}



	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

}
