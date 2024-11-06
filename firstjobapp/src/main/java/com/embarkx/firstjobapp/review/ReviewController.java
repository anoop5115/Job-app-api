package com.embarkx.firstjobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
class ReviewController {

    private final ReviewService reviewservice;
    public ReviewController(ReviewService reviewservice) {
        this.reviewservice = reviewservice;
    }







    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewservice.getAllreviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@PathVariable Long companyId, @RequestBody Review review) {
       boolean added= reviewservice.addReview(review,companyId);
       if(added)
        return new ResponseEntity<>(review, HttpStatus.OK);
       else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview( @PathVariable Long companyId,@PathVariable Long reviewId) {

        return new ResponseEntity<>(reviewservice.getReview(reviewId,companyId), HttpStatus.OK);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId, @RequestBody Review review) {
        boolean updated= reviewservice.updateReview(review,companyId,reviewId);
        if(updated)
        return new ResponseEntity<>("updated", HttpStatus.OK);
        else return new ResponseEntity<>("not updated", HttpStatus.BAD_REQUEST);
    }


}

