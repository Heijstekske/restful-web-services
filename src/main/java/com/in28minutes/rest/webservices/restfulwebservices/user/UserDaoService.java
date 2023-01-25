package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDaoService {

   private static List<User> users = new ArrayList<>();

   static {
      users.add(new User(1, "Niels", LocalDate.of(1973,8,8)));
      users.add(new User(2, "Heleen", LocalDate.of(1970,7,22)));
      users.add(new User(3, "Kaysri", LocalDate.of(1970,10,21)));
   }

   public List<User> findAll(){
      return users;
   }

   public User findById(int id){
      Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
      return users.stream().filter(predicate).findFirst().get();
   }
}
