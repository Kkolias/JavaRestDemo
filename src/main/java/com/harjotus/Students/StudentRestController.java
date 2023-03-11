package com.harjotus.Students;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "*")
public class StudentRestController {

   @Autowired
   private StudentRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(
            new Student("karkki", 2)
        );
    }

    @GetMapping("/api/students/get-all")
    public List<Student> listAll() {
        return userRepository.findAll();
    }

    
    @RequestMapping(
    value = "/api/students/new-user", 
    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Student> newUser( @RequestBody Student newUser) {
        
        try {
            Student created = userRepository.save(
            new Student(newUser.name, newUser.age)
        );
            return new ResponseEntity<>(created, HttpStatus.OK);
        } catch(Exception  e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
    value = "/api/students/edit-user-name",
    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> editUserName( @RequestBody Student payload) {
            Long id = payload.id;
            String name = payload.name;
            Student User = userRepository.findById(id).orElse(null);

            if(User == null) {
                return new ResponseEntity<>(false , HttpStatus.NOT_FOUND);
            }

            User.name = name;
            userRepository.save(User);
            
            return new ResponseEntity<>(true , HttpStatus.OK);
        
    }


}
