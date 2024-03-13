package org.example.webdemo1303.services;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.data.Course;
import org.example.webdemo1303.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void add(String course, int length) {
        courseRepository.save(new Course(course, length));
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}
