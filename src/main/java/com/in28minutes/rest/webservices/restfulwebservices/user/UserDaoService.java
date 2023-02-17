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

   private static int usersCount = 0;

   static {
      users.add(new User(++usersCount, "Niels", LocalDate.of(1973,8,8)));
      users.add(new User(++usersCount, "Heleen", LocalDate.of(1970,7,22)));
      users.add(new User(++usersCount, "Kaysri", LocalDate.of(1970,10,21)));
   }

   public List<User> findAll(){
      return users;
   }

   public User findById(int id){
      Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
      return users.stream().filter(predicate).findFirst().get();
   }

   public User save(User user){
      user.setId(++usersCount);
      users.add(user);
      return user;
   }
}
