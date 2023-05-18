package com.example.homework69.repository;

import com.example.homework69.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM reviews WHERE product_id = :id")
    List<Reviews> findReviewsByProductId(Integer id);
}
