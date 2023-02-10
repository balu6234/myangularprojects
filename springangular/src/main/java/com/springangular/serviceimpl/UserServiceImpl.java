package com.springangular.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springangular.entity.User;
import com.springangular.repository.UserRepository;
import com.springangular.service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
