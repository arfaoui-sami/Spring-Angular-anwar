package com.example.projetanwar.security.services;

import com.example.projetanwar.exception.UserNotFoundException;
import com.example.projetanwar.entities.User;
import com.example.projetanwar.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepo;
    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }



    //  public void UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

//  //  public void UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public User addUser(User user) {
      //  user.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }



    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }


    public List<User> findAllUsers() {
        {
            return userRepo.findAll();
        }
    }

    // public User findUserById(Long id) {
    //     return userRepo.findUserBy(id);
    // }
}