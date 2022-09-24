package com.example.projetanwar.Repositories;
import com.example.projetanwar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetanwar.entities.Materiel;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {
        void deleteMaterielById(Long id);


        // User findUserBy(Long id);

        Optional<Materiel> findMaterielById(Long id);
        }
