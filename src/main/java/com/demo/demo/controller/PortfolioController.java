package com.demo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Ramesh Maneddi");
        model.addAttribute("title", "Java Backend Developer");
        model.addAttribute("location", "Andhra Pradesh, Kakinada");
        model.addAttribute("phone", "+91 8309278773");
        model.addAttribute("email", "rameshmaneddi6@gmail.com");
        model.addAttribute("experience", "3+ years");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("summary", "A dedicated Java Backend Developer with 3 years of experience in developing and maintaining robust and scalable backend systems using Java and Spring Boot. Proficient in building RESTful APIs, handling databases, and implementing best practices in software development. Passionate about delivering high-quality code and solving complex problems in a collaborative environment.");
        return "about";
    }

    @GetMapping("/skills")
    public String skills() {
        return "skills";
    }

    @GetMapping("/projects")
    public String projects() {
        return "projects";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam(value = "privacy", required = false) String privacy,
            RedirectAttributes redirectAttributes) {
        
        // Log the contact form submission (in a real application, you would save to database or send email)
        System.out.println("Contact Form Submission:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("Privacy Accepted: " + (privacy != null));
        
        // Add success message
        redirectAttributes.addFlashAttribute("successMessage", 
            "Thank you for your message! I'll get back to you soon.");
        
        return "redirect:/";
    }
}

