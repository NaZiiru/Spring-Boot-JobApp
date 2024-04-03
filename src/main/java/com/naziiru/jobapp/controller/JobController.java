package com.naziiru.jobapp.controller;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAllJobs();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job newJob) {
      jobService.createJob(newJob);
        return "Job Added Succesfully";
    }
}
