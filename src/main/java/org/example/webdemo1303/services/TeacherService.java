package org.example.webdemo1303.services;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.data.Teacher;
import org.example.webdemo1303.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private TeacherRepository repository;
//    private CourseService courseService;

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public List<Teacher> getTeachersForCourse(int courseId) {
        return repository.findByCourses_Id(courseId);
    }

    public List<Teacher> getTeachersAvailableForCourse(int courseId) {
        return repository.findTeachersAvailableForCourse(courseId);
    }


    public Teacher find(int tid) {
        return repository.findById(tid).get();
    }
}
