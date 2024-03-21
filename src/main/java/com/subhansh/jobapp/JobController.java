package com.subhansh.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subhansh.jobapp.model.JobPost;
import com.subhansh.jobapp.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @RequestMapping({ "/", "home" })
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost, Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJob(jobPost);
        System.out.println("Form method called");
        return "success";

    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = service.getAllJobs();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}
