package com.example.homework69.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDto {
    private String description;
    private LocalDateTime descriptionTime;
}
