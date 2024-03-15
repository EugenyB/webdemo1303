package org.example.webdemo1303.repositories;

import org.example.webdemo1303.data.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByCourses_Id(Integer id);

    @Query("select t from Teacher t where not exists (select 1 from Course c where t member of c.teachers and c.id = ?1)")
    List<Teacher> findTeachersAvailableForCourse(Integer id);
}