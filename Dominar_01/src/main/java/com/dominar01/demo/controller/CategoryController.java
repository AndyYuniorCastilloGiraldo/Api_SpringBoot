package com.dominar01.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominar01.demo.Service.CategoryService;
import com.dominar01.demo.model.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/Category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService service;


	@GetMapping
	public ResponseEntity<List<Category>> getCategorys() {
		//service = new CategoryServiceImpl();
		List<Category> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory( @PathVariable ("id") Integer id) {
		//service = new CategoryServiceImpl();
		Category category = service.findById(id);
		return ResponseEntity.ok(category);
	}
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category categorys) {
		Category newCategory = service.guardar(categorys);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory( @PathVariable("id") Integer id, @RequestBody Category categorys) {
		Category newCategory = service.actualizar(id, categorys);
		return ResponseEntity.ok(newCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory( @PathVariable ("id") Integer id) {
		//service = new CategoryServiceImpl();
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}


