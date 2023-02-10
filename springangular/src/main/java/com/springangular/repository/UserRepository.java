package com.springangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springangular.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
