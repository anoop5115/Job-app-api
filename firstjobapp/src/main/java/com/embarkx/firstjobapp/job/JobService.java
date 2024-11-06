package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job get_Byid(Long id);
    int delete_Byid(Long id);
    boolean updateJob(Long id,Job job);
}
