package com.springangular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERS")
public class User {
	@Id
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="userAddress")
    private String userAddress;
}
