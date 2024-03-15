package org.example.webdemo1303.repositories;

import org.example.webdemo1303.data.Course;
import org.example.webdemo1303.data.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}