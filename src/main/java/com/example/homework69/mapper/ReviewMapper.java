package com.example.homework69.mapper;

import com.example.homework69.dto.ReviewDto;
import com.example.homework69.entity.Reviews;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto fromReview(Reviews reviews) {
        return ReviewDto.builder()
                .description(reviews.getDescription())
                .descriptionTime(reviews.getDescriptionTime())
                .build();
    }
}
