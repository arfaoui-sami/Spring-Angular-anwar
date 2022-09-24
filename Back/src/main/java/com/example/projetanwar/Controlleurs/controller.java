package com.example.projetanwar.Controlleurs;


import com.example.projetanwar.entities.UserModel;
import com.example.projetanwar.security.services.FetchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class controller {
    @Autowired
    FetchDataService fetchDataService;



    @CrossOrigin(origins ="*")

    @GetMapping(path="getdata")
    List<UserModel> getUsers(){
        return fetchDataService.findAll();

    }

}