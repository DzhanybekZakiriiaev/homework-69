package com.example.homework69.repository;

import com.example.homework69.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "select b from Brand as b")
    List<Brand> findAllBrand();
}
