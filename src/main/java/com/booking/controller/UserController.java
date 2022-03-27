package com.booking.controller;

import com.booking.entity.Users;
import com.booking.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final MongoTemplate mongoTemplate;

    private final UserService userService;

    public UserController(MongoTemplate mongoTemplate, UserService userService) {
        this.mongoTemplate = mongoTemplate;
        this.userService = userService;
    }

    @GetMapping("status")
    public String getStatus() {
        return "{Status:200}";
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> getAllUser() {
        return new ResponseEntity<List<Users>>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> saveUser(@RequestBody Users user) {
        try {
            Users savedUser = userService.saveUser(user);
            logger.info("User creation Successful");
            return new ResponseEntity<String>(user.getUsername(), HttpStatus.OK);

        } catch (Exception e) {
            logger.warn(e.getMessage());

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
