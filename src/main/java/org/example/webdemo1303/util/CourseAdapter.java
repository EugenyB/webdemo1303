package org.example.webdemo1303.util;

import lombok.AllArgsConstructor;
import org.example.webdemo1303.data.Course;

import java.util.Optional;

@AllArgsConstructor
public class CourseAdapter {
    private Optional<Course> optionalCourse;

    public Integer getId() {
        return optionalCourse.isPresent() ? optionalCourse.get().getId() : 0;
    }

    public Integer getLength() {
        return optionalCourse.isPresent() ? optionalCourse.get().getLength() : 0;
    }

    public String getTitle() {
        return optionalCourse.isPresent() ? optionalCourse.get().getTitle() : "course not found";
    }
}
