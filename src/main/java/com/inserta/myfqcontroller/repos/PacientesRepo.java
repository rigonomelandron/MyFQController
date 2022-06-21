package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "pacientes")
public interface PacientesRepo extends JpaRepository<Paciente, String> {
    public Paciente findByDni(String dni);
    public Paciente findByIdUsuario(String username);
}
