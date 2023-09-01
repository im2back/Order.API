package com.github.im2back.Order.Api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.im2back.Order.Api.model.category.Category;
import com.github.im2back.Order.Api.model.category.CategoryAllAttributesDTO;
import com.github.im2back.Order.Api.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryAllAttributesDTO> findAll(){
			var categoryList=	repository.findAll();
			List<CategoryAllAttributesDTO> responseList = categoryList.stream().map(CategoryAllAttributesDTO::new)
					.collect(Collectors.toList());
						return responseList;
	}
	
	public CategoryAllAttributesDTO findById(Long id) {
		Optional<Category> category = repository.findById(id);
		
			return new CategoryAllAttributesDTO(category.get());
				
		
	}
}
