package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(User user) {
		String password = user.getPassword();
		String encodedPassword = encoder.encode(password);
		user.setPassword(encodedPassword);
		
		userrepository.save(user);
	}
}
