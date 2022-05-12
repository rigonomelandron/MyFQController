package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "eventos")
public interface EventosRepo extends JpaRepository<Evento, Integer> {
    public List<Evento> findByDni_paciente(String dni);
    public List<Evento> findByDni_pacienteAAndFecha(String dni, LocalDateTime fecha);

}
