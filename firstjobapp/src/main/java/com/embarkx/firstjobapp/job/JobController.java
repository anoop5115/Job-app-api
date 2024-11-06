package com.embarkx.firstjobapp.job;//package com.embarkx.firstjobapp.job;
//
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
private  JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping ("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){

       jobService.createJob(job);
       return new ResponseEntity<>("Job added suceesfully",HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> get_JobById(@PathVariable Long id){

      Job job=jobService.get_Byid(id);
      if(job!=null){
          return new ResponseEntity<>(job, HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;

    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
       int deleted= jobService.delete_Byid(id);
       if(deleted==1)  return new ResponseEntity<>("Job deleted suceesfully",HttpStatus.OK);
       else return new ResponseEntity<>("Job not deleted",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updated= jobService.updateJob(id,job);
        if(updated) return new ResponseEntity<>("Job updated suceesfully",HttpStatus.OK);
        else return new ResponseEntity<>("Job not updated",HttpStatus.NOT_FOUND);

    }

}
