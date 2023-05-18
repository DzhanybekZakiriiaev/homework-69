package com.example.homework69.mapper;


import com.example.homework69.dto.BrandDto;
import com.example.homework69.entity.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public static BrandDto fromBrand(Brand brand) {
        return BrandDto.builder()
                .name(brand.getBrand())
                .build();
    }

}
