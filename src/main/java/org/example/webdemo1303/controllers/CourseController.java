package org.example.webdemo1303.controllers;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("courses", courseService.getCourses());
        return "courses";
    }

    @PostMapping("/add")
    public String add(@RequestParam String course, @RequestParam int length) {
        courseService.add(course, length);
        return "redirect:/courses";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "course_id") int id) {
        courseService.delete(id);
        return "redirect:/courses";
    }
}
