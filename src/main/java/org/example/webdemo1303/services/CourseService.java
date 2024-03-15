package org.example.webdemo1303.services;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.data.Course;
import org.example.webdemo1303.repositories.CourseRepository;
import org.example.webdemo1303.util.CourseAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    private TeacherService teacherService;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void add(String course, int length) {
        courseRepository.save(new Course(course, length));
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }

    public CourseAdapter getCourse(int courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return new CourseAdapter(course);
    }

    public void removeTeacher(int cid, int tid) {
        courseRepository.findById(cid).ifPresent(c->{
            c.getTeachers().removeIf(t->t.getId()==tid);
            courseRepository.save(c);
        });
    }

    public void addTeacher(int cid, int tid) {
        courseRepository.findById(cid).ifPresent(c->{
            c.getTeachers().add(teacherService.find(tid));
            courseRepository.save(c);
        });
    }

}
