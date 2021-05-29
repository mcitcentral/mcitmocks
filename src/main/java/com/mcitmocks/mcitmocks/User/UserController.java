package com.mcitmocks.mcitmocks.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@Transactional
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User userParam){
        User createdUser= this.userService.addUser(userParam);
        return ResponseEntity.ok(createdUser);

    }
}
