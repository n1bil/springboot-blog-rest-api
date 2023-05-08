package com.springboot.blog.mapper;

import com.springboot.blog.entity.Category;
import com.springboot.blog.payload.CategoryDto;

public class CategoryMapper {

    // map category to categoryDto
    public static CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    // map categoryDto to category
    public static Category mapToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
    }
}
