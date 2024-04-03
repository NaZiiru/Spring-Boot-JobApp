package com.naziiru.jobapp.controller;

import com.naziiru.jobapp.domain.Job;
import com.naziiru.jobapp.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job newJob) {
      jobService.createJob(newJob);
        return new ResponseEntity<>("Job Added Succesfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted)
            return ResponseEntity.ok("Job deleted Succesfully");
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id , @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        if (isUpdated)
            return new ResponseEntity<>("Job updated Sucessfully",HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }
}
