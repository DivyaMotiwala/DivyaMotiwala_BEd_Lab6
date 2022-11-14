package com.divyamotiwala.Lab6StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.divyamotiwala.Lab6StudentManagement.model.User;
import com.divyamotiwala.Lab6StudentManagement.repository.UserRepository;
import com.divyamotiwala.Lab6StudentManagement.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findUserByUserName(username);
		if(user == null)
			throw new UsernameNotFoundException(username);
		UserDetails userDetails = new MyUserDetails(user);
		return userDetails;
	}
	
	

}
