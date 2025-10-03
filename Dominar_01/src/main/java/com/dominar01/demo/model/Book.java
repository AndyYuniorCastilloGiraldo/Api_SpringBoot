package com.dominar01.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	
	@Id
	private Integer idBook;
	
	@Column(name = "Titulo", length = 50, nullable = false)
	private String title;

	@Column(name = "Autor", length = 50, nullable = false)
	private String author;

	@Column(name = "Precio", nullable = false)
	private double precio;
}
