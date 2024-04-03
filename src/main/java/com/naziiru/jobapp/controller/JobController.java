package com.naziiru.jobapp.controller;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job newJob) {
      jobService.createJob(newJob);
        return new ResponseEntity<>("Job Added Succesfully", HttpStatus.CREATED);
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
