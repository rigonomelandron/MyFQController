package com.inserta.myfqcontroller.security.repository;

import com.inserta.myfqcontroller.models.Rol;
import com.inserta.myfqcontroller.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
