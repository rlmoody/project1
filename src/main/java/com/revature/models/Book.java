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
@Table(name = "books", schema = "project1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {

		@Id // primary key field
		@Column(name = "book_id", nullable = false, updatable = false)
		
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Length(min = 1)
		@Size
		private String title;
		private String author;
		private String genre;
		
		private Boolean available;


}
