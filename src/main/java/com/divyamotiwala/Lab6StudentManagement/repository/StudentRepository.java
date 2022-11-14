package com.divyamotiwala.Lab6StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyamotiwala.Lab6StudentManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
