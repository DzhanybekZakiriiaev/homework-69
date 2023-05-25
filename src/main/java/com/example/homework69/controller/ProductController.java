package com.example.homework69.controller;

import com.example.homework69.dto.ProductDto;
import com.example.homework69.dto.ReviewDto;
import com.example.homework69.entity.Reviews;
import com.example.homework69.mapper.ProductMapper;
import com.example.homework69.mapper.ReviewMapper;
import com.example.homework69.service.ProductService;
import com.example.homework69.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/product/")
public class ProductController {
    final private ProductService productService;
    final private ReviewService reviewService;
    final private ProductMapper productMapper;
    final private ReviewMapper reviewMapper;

    @GetMapping("all")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts()
                .stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    @GetMapping("comment")
    public List<ReviewDto> getCommentsByIdProduct(@RequestParam(name = "productId", required = false) Integer id) {
        return reviewService.getReviewsById(id)
                .stream()
                .map(reviewMapper::fromReview)
                .collect(Collectors.toList());
    }

    @PostMapping("/review")
    public Reviews leaveComment(@RequestParam Reviews review){
        return reviewService.save(review);
    }

    @GetMapping("search")
    public List<ProductDto> getProductWithName(@RequestParam("name") String name,
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(required = false, defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.findByNamePage(name, pageable)
                .stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    @GetMapping("brand")
    public List<ProductDto> getProductWithBrand(@RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "description", required = false) String description,
                                                @RequestParam(required = false, defaultValue = "4") int size,
                                                @RequestParam(value = "min", required = false) Integer min,
                                                @RequestParam(value = "max", required = false) Integer max) {
        System.out.println(name + " de "+ description + " price "+ min + max);
        Pageable pageable = PageRequest.of(page, size);
        List<ProductDto> list = new ArrayList<>();
        if (name != null && description != null && min != null && max != null) {
            list = productService.findByMaxMinNameDesc(name, description, min, max, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
            System.out.println(1);
        } else if (name != null && description != null) {
            list = productService.findByBrandAndDesc(name, description, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
            System.out.println(2);
        } else if (name != null && min != null && max != null) {
            list = productService.findByNameBetween(name, min, max, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
            System.out.println(3);
        } else if (description != null && min != null && max != null) {
            list = productService.findByDescBetween(description, min, max, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
            System.out.println(4);
        } else if (min != null && max != null) {
            list = productService.findByBetween(max, min, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
            System.out.println(5);
        } else if (name != null) {
            list = productService.findByBrandPage(name, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
        } else if (description != null) {
            list = productService.findByDesc(description, pageable)
                    .stream()
                    .map(productMapper::fromProduct)
                    .collect(Collectors.toList());
        }
        return list;
    }
}
