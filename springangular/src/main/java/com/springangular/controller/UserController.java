package com.springangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springangular.entity.User;
import com.springangular.serviceimpl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
@Autowired
UserServiceImpl userServiceImpl;
@PostMapping("/user")
User saveBook(@RequestBody User user)
{
   return userServiceImpl.saveUser(user);
}
@GetMapping("/getuser")
public List <User> getAllUsers(@RequestBody User user)
{
	
	return userServiceImpl.getAllUsers();
}

}
