package org.example.webdemo1303.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses = new LinkedHashSet<>();

}