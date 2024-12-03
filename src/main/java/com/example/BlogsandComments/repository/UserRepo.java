package com.example.BlogsandComments.repository;

import com.example.BlogsandComments.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
    @Query("SELECT u.password FROM User u WHERE u.email = :email")
    String findPasswordByEmail(@Param("email") String email);

    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);

    List<User> findByIdIn(List<Integer> ids);

}
