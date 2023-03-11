package com.harjotus.Students;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int age;

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

    // public User getUser() {
    //     return new User(name, price, id);
    // }

    
}