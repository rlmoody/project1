package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", schema = "project1")
@Data @NoArgsConstructor @AllArgsConstructor

public class User {

	@Id // primary key field
	@Column(name = "user_id", nullable = false, updatable = false)
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Length(min = 1)
	@Size
	private String firstName;
	private String lastName;
	
	@Length(min = 5)
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	
	@NotEmpty
	private String password;
	private String address;


}
