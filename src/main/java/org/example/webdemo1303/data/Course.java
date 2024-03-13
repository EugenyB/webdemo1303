package org.example.webdemo1303.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "length")
    private Integer length;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "courses_teachers",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

    public Course(String title, Integer length) {
        this.length = length;
        this.title = title;
    }
}