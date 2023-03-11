package com.harjotus.Courses;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.harjotus.Students.Student;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int op;

    @ManyToMany(mappedBy = "courses")
    Set<Student> likes;

    public Course() {}

    public Course(String name, int op) {
        this.name = name;
        this.op = op;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOp() {
        return this.op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public void setId(Long id) {
        this.id = id;
    } 
    
    public Long getId(Long id) {
        return this.id;
    }

}
