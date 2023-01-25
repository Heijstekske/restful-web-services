package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
