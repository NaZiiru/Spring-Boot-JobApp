package com.naziiru.jobapp.services.impl;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long uuid = 1L;

    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }
    @Override
    public void createJob(Job job) {
        job.setId(uuid++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
       for(Job job:jobs)
       {
           if(job.getId().equals(id)) return job;
       }
       return null;
    }
}
