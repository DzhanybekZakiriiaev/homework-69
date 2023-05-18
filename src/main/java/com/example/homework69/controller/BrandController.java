package com.example.homework69.controller;


import com.example.homework69.dto.BrandCreateDto;
import com.example.homework69.dto.BrandDto;
import com.example.homework69.entity.Brand;
import com.example.homework69.mapper.BrandMapper;
import com.example.homework69.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class BrandController {
    final private BrandService brandService;
    final private BrandMapper brandMapper;

    @GetMapping("brands/")
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands().stream()
                .map(brand -> brandMapper.fromBrand(brand))
                .collect(Collectors.toList());
    }

    @PostMapping("brand/add/")
    public BrandDto addBrand(@RequestBody BrandCreateDto brandCreateDto) {
        Brand brand = brandService.saveBrand(brandCreateDto.getName());
        return brandMapper.fromBrand(brand);
    }
}
