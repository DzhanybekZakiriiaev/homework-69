package com.example.homework69.mapper;


import com.example.homework69.dto.CategoryDto;
import com.example.homework69.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public static CategoryDto fromCategory(Category category) {
        return CategoryDto.builder()
                .name(category.getCategory())
                .build();
    }
}
