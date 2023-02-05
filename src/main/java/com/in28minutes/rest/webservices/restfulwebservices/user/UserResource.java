package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
      User userById = userDaoService.findById(id);

      if (userById==null){
         throw new UserNotFoundException("id:"+id);
      }
      return userById;
   }

   @PostMapping("/users")
   public ResponseEntity<User> createUser(@RequestBody User user){
      User savedUser = userDaoService.save(user);
      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
      return ResponseEntity.created(location).build();
   }
}
