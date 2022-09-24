package com.example.projetanwar.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetanwar.entities.Role;
import com.example.projetanwar.entities.RoleName;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{


    Optional<Role> findByName(RoleName name);
}
