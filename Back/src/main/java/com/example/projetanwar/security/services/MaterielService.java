package com.example.projetanwar.security.services;

import com.example.projetanwar.Repositories.MaterielRepository;
import com.example.projetanwar.entities.Materiel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaterielService {
    private final MaterielRepository materielRepo;
    @Autowired
    public MaterielService(MaterielRepository materielRepo) {
        this.materielRepo = materielRepo;
    }



    //  public void UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

//  //  public void UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public Materiel addMateriel(Materiel materiel) {
        //  user.setUserCode(UUID.randomUUID().toString());
        return materielRepo.save(materiel);
    }



    public Materiel updateMateriel(Materiel materiel) {
        return materielRepo.save(materiel);
    }

    public Materiel findMaterielById(Long id) {
        return materielRepo.findMaterielById(id)
                .orElseThrow(() -> new MaterielNotFoundException("Materiel by id " + id + " was not found"));
    }


    public void deleteMateriel(Long id){
        materielRepo.deleteMaterielById(id);
    }

    public List<Materiel> findAllMateriels() {
        {
            return materielRepo.findAll();
        }
    }

    private class MaterielNotFoundException extends RuntimeException {
        public MaterielNotFoundException(String s) {
        }
    }

    // public User findUserById(Long id) {
    //     return userRepo.findUserBy(id);
    // }
}