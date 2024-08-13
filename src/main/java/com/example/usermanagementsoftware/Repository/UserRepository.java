package com.example.usermanagementsoftware.Repository;

import com.example.usermanagementsoftware.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    User checkUsernameAndPassword(String username,String password);

    User findUserByEmail(String email);

    List<User> findUserByRole(String role);

    @Query("SELECT u FROM User u WHERE u.age >= ?1")
    List<User> findUserByAgeOrAbove(int age);
}
