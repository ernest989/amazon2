package com.product.api.controller; 
 
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.api.dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CtrlCategory {
	
	@Autowired 
	SvcCategory svc;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1,"Lentes","Lts",1));
		categories.add(new Category(2,"Chamarra","Chmr",1));
		categories.add(new Category(3,"Playera","Plyr",1));
		return ResponseEntity.ok(svc.findAll());
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<Category>>findActive(){
		return ResponseEntity.ok(svc.findActive());
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse>create(@Valid @RequestBody DtoCategoryIn in){
		return ResponseEntity.ok(svc.create(in));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse>update(@PathVariable("id")Integer id, DtoCategoryIn in){
		return ResponseEntity.ok(svc.update(in, id));
	}
	
	@PatchMapping("/{id}/enable")
	public ResponseEntity<ApiResponse>enable(@PathVariable Integer id){
		return ResponseEntity.ok(svc.enable(id));
	}
	
	@PatchMapping("/{id}/disable")
	public ResponseEntity<ApiResponse>disable(@PathVariable Integer id){
		return ResponseEntity.ok(svc.disable(id));
	}
	
	
}
