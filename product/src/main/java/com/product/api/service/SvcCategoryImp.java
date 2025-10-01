package com.product.api.service;
import java.util.List;

import com.product.api.dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.DBAccessException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SvcCategoryImp implements SvcCategory {

	@Autowired
	RepoCategory repo;
	
	@Override
	public ResponseEntity<List<Category>> getCategories(){
		return new ResponseEntity<>(repo.getCategories(),HttpStatus.OK);
	}
	
	@Override
	public List<Category>findAll(){
		try {
			return repo.findAll();
		}catch(DataAccessException e){
			throw new DBAccessException();
		}
	}

	@Override
	public List<Category> findActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse create(DtoCategoryIn in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse update(DtoCategoryIn in, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse enable(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse disable(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RepoCategory getRepo() {
		return repo;
	}

	public void setRepo(RepoCategory repo) {
		this.repo = repo;
	}
	
}
