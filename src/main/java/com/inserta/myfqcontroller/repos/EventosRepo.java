package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "eventos")
public interface EventosRepo extends JpaRepository<Evento, Integer> {
}
