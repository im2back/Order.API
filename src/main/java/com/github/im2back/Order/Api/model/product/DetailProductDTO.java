package com.github.im2back.Order.Api.model.product;

import java.util.Set;

import com.github.im2back.Order.Api.model.category.Category;

public record DetailProductDTO(
		Long id,
		String name,
		String description,
		Double price,
		String imgUrl,
		Set<Category> categories
		) {
	public DetailProductDTO(Product product) {
		this(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getImgUrl(),product.getCategories());
	}

}
