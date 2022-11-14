package com.divyamotiwala.Lab6StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divyamotiwala.Lab6StudentManagement.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findUserByUserName(String userName);
}
