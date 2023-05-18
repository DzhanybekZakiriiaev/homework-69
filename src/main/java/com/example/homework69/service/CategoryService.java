package com.example.homework69.service;

import com.example.homework69.entity.Category;
import com.example.homework69.repository.CategoryRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    final private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAllBy();
    }
}
