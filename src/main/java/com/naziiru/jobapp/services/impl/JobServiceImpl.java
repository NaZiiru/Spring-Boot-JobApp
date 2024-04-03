package com.naziiru.jobapp.services.impl;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }
    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
