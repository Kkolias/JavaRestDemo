package com.harjotus.Users;

import javax.annotation.PostConstruct;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

//     @Autowired
//    private UserRepository userRepository;

//     @PostConstruct
//     public void init() {
//         userRepository.save(
//             new User("useri", 2)
//         );
//     }

    // @GetMapping("/api/users/get-all")
    // public List<User> listAll() {
    //     return userRepository.findAll();
    // }
    
    @GetMapping("/")
    public String getBasicInfo() {
        return "returnii";
    }


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
