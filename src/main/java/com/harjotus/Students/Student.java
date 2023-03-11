package com.harjotus.Students;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.harjotus.Courses.Course;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int age;

    @ManyToMany
    @JoinTable(
        name = "courses", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    public List<Course> courses;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.age;
    }

    public void setPrice(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    } 
    
    public Long getId(Long id) {
        return this.id;
    }    

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }
}