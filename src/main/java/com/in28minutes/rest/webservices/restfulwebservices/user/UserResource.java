package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

   UserDaoService userDaoService;

   public UserResource(UserDaoService userDaoService) {
      this.userDaoService = userDaoService;
   }

   @GetMapping("/users")
   public List<User> retrieveAllUsers() {
      return userDaoService.findAll();
   }

   @GetMapping("/users/{id}")
   public User retrieveUserById(@PathVariable int id){
      return userDaoService.findById(id);
   }

   @PostMapping("/users")
   public void createUser(@RequestBody User user){
      userDaoService.save(user);
   }
}
