package com.harjotus.Courses;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harjotus.Students.Student;

@RestController
@CrossOrigin(origins = "*")
public class CourseRestController {
    
    @Autowired
   private CourseRepository courseRepository;

    @PostConstruct
    public void init() {
        courseRepository.save(
            new Course("kurssi", 20)
        );
    }

    @GetMapping("/api/courses/get-all")
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @RequestMapping(
        value = "/api/courses/new-course", 
        method = RequestMethod.POST)
        @ResponseBody
        public ResponseEntity<Course> newUser( @RequestBody Course newCourse) {
            
            try {
                Course created = courseRepository.save(
                new Course(newCourse.name, newCourse.op)
            );
                return new ResponseEntity<>(created, HttpStatus.OK);
            } catch(Exception  e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    
    }

    @RequestMapping(
        value = "/api/courses/remove-course", 
        method = RequestMethod.POST)
        @ResponseBody
        public ResponseEntity<Course> removeCourse(@RequestParam Long courseId) {
            
            try {
                Course course = courseRepository.findById(courseId).orElse(null);
                courseRepository.delete(course);
        
                return new ResponseEntity<>(HttpStatus.OK);
            } catch(Exception  e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    
    }
}
