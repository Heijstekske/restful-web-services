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
   private static int userCount = 0;


   static {
      users.add(new User(++userCount, "Niels", LocalDate.of(1973,8,8)));
      users.add(new User(++userCount, "Heleen", LocalDate.of(1970,7,22)));
      users.add(new User(++userCount, "Kaysri", LocalDate.of(1970,10,21)));
   }

   public List<User> findAll(){
      return users;
   }

   public User findById(int id){
      Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
      return users.stream().filter(predicate).findFirst().orElse(null);
   }

   public User save(User user) {
      user.setId(++userCount);
      users.add(user);
      return user;
   }

   public void deleteById(int id){
      Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
      users.removeIf(predicate);
   }
}
