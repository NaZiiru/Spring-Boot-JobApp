package com.naziiru.jobapp.controller;

import com.naziiru.jobapp.domain.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobs;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job newJob) {
        jobs.add(newJob);
        return "Job Added Succesfully";
    }
}
