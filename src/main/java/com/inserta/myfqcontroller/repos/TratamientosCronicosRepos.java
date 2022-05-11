package com.inserta.myfqcontroller.repos;


import com.inserta.myfqcontroller.models.TratamientoCronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path="tratamientos")
public interface TratamientosCronicosRepos extends JpaRepository<TratamientoCronico,Integer> {
    public List<TratamientoCronico> findByDniPaciente(String dni);
    public List<TratamientoCronico> findByDniPacienteAndFecha(String dni, LocalDateTime fecha);
}
