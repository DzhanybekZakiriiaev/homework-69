package com.example.homework69.service;

import com.example.homework69.entity.Reviews;
import com.example.homework69.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    final private ReviewRepository reviewRepository;

    public List<Reviews> getReviewsById(Integer id) {
        return reviewRepository.findReviewsByProductId(id);
    }

    public Reviews save(Reviews reviews){
        return reviewRepository.save(reviews);
    }
}
