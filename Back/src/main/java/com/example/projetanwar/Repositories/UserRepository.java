package com.example.projetanwar.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projetanwar.entities.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    void deleteUserById(Long id);

    // User findUserBy(Long id);

    Optional<User> findUserById(Long id);

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPhone(String phone);
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);
    Boolean existsByImageUrl(String imageUrl);






}
