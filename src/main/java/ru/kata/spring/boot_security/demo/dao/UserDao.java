package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

public interface UserDao extends JpaRepository<User, Long> {
   @Query("select distinct u from User u join fetch u.roles where u.firstName=(:firstName)")
   Set<User> findByFirstName(@Param("firstName") String firstName);
}
