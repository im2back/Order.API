package com.github.im2back.Order.Api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.im2back.Order.Api.model.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
