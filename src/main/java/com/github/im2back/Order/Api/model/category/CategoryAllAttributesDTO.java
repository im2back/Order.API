package com.github.im2back.Order.Api.model.category;

public record CategoryAllAttributesDTO(
		Long id,
		String name
		) {
	
	public CategoryAllAttributesDTO(Category category) {
		this(category.getId(),category.getName());
	}

}
