package com.springangular.service;

import java.util.List;

import com.springangular.entity.User;

public interface UserService {
   User saveUser(User user);
   public List <User> getAllUsers();

}
