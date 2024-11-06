package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private  Long nextId=1L;
//    private  List<Job> jobs=new ArrayList<Job>();

    JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob( Job job) {
        job.setId(nextId++);
        jobRepository.save(job);

    }

    @Override
    public Job get_Byid(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public int  delete_Byid(Long id) {

   try {
       jobRepository.deleteById(id);
       return 1;
   }
   catch (Exception e) {
       return 0;
   }



    }

    @Override
    public boolean updateJob(Long id,Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()) {
                Job job1 = jobOptional.get();
                job1.setCompany(job.getCompany());
                job1.setDescription(job.getDescription());
                job1.setLocation(job.getLocation());
                job1.setMaxsalary(job.getMaxsalary());
                job1.setMinsalary(job.getMinsalary());
                job1.setTitle(job.getTitle());
jobRepository.save(job1);
                return true;
            }

        return false;

    }
}
