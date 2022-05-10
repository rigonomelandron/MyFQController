package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path="deportes")
public interface DeportesRepo extends JpaRepository<Deporte, Integer> {

    public List<Deporte> findByDniPaciente(String dni);
    public List<Deporte> findByDniPacienteAndFecha(String dni, LocalDateTime fecha);
}
