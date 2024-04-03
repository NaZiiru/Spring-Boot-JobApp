package com.naziiru.jobapp.services;


import com.naziiru.jobapp.domain.Job;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job job);
}
