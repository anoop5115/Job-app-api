package com.embarkx.firstjobapp.review;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    List<Review> getAllreviews(Long companyId);
   boolean addReview(Review review,Long companyId);
   Review getReview(Long reviewId,Long companyId);
  boolean updateReview(Review review,Long companyId,Long reviewId);
}
