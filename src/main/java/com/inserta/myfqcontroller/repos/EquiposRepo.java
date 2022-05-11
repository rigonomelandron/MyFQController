package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "equipos")
public interface EquiposRepo extends JpaRepository<Equipo, Integer> {
}
