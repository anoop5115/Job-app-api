package com.embarkx.firstjobapp.review.impl;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyService;
import com.embarkx.firstjobapp.company.impl.CompanyServiceimpl;
import com.embarkx.firstjobapp.review.Review;
import com.embarkx.firstjobapp.review.ReviewRepository;
import com.embarkx.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Reviewserviceimpl implements ReviewService {
    private final ReviewRepository reviewrepository;
    private final CompanyServiceimpl companyService;

    public Reviewserviceimpl(ReviewRepository reviewrepository, CompanyService companyservice, CompanyServiceimpl companyService) {
        this.reviewrepository = reviewrepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllreviews(Long companyId) {
        return reviewrepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Review review, Long companyId) {
        Company company=companyService.getcompany(companyId);
        if(company!=null){

            review.setCompany(company);
             reviewrepository.save(review);
             return true;
        }
        return false;

    }

    @Override
    public Review getReview(Long reviewId, Long companyId) {
        List<Review> reviews= reviewrepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);

    }

    @Override
    public boolean updateReview(Review updatedreview, Long companyId, Long reviewId) {
        if(companyService.getcompany(companyId) != null){
            updatedreview.setCompany(companyService.getcompany(companyId));
            updatedreview.setId(reviewId);
            reviewrepository.save(updatedreview);
            return true;
        }
        return false;
    }
}
