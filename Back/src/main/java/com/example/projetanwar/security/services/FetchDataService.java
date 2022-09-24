package com.example.projetanwar.security.services;

import com.example.projetanwar.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface FetchDataService extends JpaRepository<UserModel, Integer> {

    @Override
    List<UserModel> findAll();


}