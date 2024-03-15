package org.example.webdemo1303.controllers;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.data.Teacher;
import org.example.webdemo1303.services.CourseService;
import org.example.webdemo1303.services.TeacherService;
import org.example.webdemo1303.util.CourseAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

   private TeacherService teacherService;
   private CourseService courseService;

    @GetMapping("/course/{id}")
    public String teachersForCourse(@PathVariable(name = "id") int courseId, Model model) {
        List<Teacher> teachersForCourse = teacherService.getTeachersForCourse(courseId);
        model.addAttribute("teachers", teachersForCourse);
        CourseAdapter courseAdapter = courseService.getCourse(courseId);
        model.addAttribute("course", courseAdapter);
        List<Teacher> available = teacherService.getTeachersAvailableForCourse(courseId);
        model.addAttribute("available", available);
        return "course_teachers";
    }

}
