package org.example.webdemo1303.repositories;

import org.example.webdemo1303.data.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}