package com.nexxy.controllers.user;

import com.nexxy.entities.User;
import com.nexxy.repository.UserRepository;
import com.nexxy.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/api")
@CrossOrigin(origins = "*") // Replace with your Angular app domain
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        User success = userService.createUser(user);
        if(user == null){
            return ResponseEntity.ok("Successfully added!");
        }else {
            return ResponseEntity.badRequest().body("Failed");
        }
    }
}
