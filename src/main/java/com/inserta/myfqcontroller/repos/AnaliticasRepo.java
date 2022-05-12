package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Analitica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "analiticas")
public interface  AnaliticasRepo extends JpaRepository<Analitica, Integer> {
    public List<Analitica> findByDniPaciente(String dni);
    public List<Analitica> findByDniPacienteAndFecha(String dni, LocalDateTime fecha);
}
