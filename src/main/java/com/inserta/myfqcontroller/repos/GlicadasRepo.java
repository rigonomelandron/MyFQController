package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Glicada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "glicada")
public interface GlicadasRepo extends JpaRepository<Glicada, Integer> {
    public List<Glicada> findByDni_paciente(String dni);
    public List<Glicada> findByDni_pacienteAndFecha(String dni, LocalDateTime fecha);
}
