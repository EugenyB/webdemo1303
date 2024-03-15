package org.example.webdemo1303.controllers;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/teacher/remove/{cid}/{tid}")
    public String removeTeacherFromCourse(@PathVariable int cid, @PathVariable int tid) {
        courseService.removeTeacher(cid, tid);
        return "redirect:/teachers/course/"+cid;
    }

    @GetMapping("/teacher/add/{cid}/{tid}")
    public String addTeacherToCourse(@PathVariable int cid, @PathVariable int tid) {
        courseService.addTeacher(cid, tid);
        return "redirect:/teachers/course/"+cid;
    }
}
