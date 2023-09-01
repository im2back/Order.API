package com.github.im2back.Order.Api.model.category;

public record CategoryOnlyNameDTO(
		String name
		) {
	
	public CategoryOnlyNameDTO(Category category) {
		this(category.getName());
	}

}
