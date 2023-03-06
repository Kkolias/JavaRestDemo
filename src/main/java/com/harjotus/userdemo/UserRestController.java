package com.harjotus.userdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    
    @GetMapping("/")
    public String getBasicInfo() {
        return "returnii";
    }

    // @GetMapping("/user")
    // public User getUser() {
    //     return new User("nimi", 23);
    // }

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        return new ResponseEntity<>(new User("nimi", 23), HttpStatus.OK);
    }

    @GetMapping("/users")
    public User[] getUsers() {
        return new User[]{
            new User("eka", 1),
            new User("toka", 2),
            new User("kolmas", 3)
        };
    }

    @GetMapping("/api/foos")
    public String getFoos(@RequestParam String id) {
    if(id.equals("123"))
        return "ID: " + id;

    return "ONON: " + id;
    }

    @GetMapping("/api/bar/{id}")
    public String getBarById(@PathVariable String id) {
        return "ID: " + id;
    }

    @GetMapping("/api/sum/{x}/{y}")
    public Integer getSum(@PathVariable Integer x, @PathVariable Integer y) {
        return x + y;
    }


}
