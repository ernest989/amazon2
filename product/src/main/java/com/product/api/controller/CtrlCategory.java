package com.product.api.controller; 
 
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

@RestController("/Category")
public class CtrlCategory {
	
	@Autowired 
	SvcCategory svc;

	@GetMapping
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1,"Lentes","Lts",1));
		//2 más
		return categories;
	}
}
