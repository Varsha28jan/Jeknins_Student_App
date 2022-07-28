package com.yuki.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuki.monster.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{

}
