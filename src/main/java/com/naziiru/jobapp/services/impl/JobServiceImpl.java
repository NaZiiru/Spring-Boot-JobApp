package com.naziiru.jobapp.services.impl;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext())
        {
            Job job = iterator.next();
            if (job.getId().equals(id))
            {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        for(Job job:jobs)
        {
            if (job.getId().equals(id))
            {
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalary(updateJob.getMinSalary());
                job.setMaxSalary(updateJob.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
