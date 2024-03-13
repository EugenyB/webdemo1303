package org.example.webdemo1303.repositories;

import org.example.webdemo1303.data.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}