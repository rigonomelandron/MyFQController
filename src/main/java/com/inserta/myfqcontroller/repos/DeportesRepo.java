package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path="deportes")
public interface DeportesRepo extends JpaRepository<Deporte, Integer> {

    public List<Deporte> findByPaciente_Dni(String dni);
    public List<Deporte> findByPaciente_DniAndFecha(String dni, Date fecha);

    public List<Deporte> findByPaciente_IdUsuarioAndFecha(String idUsuario, Date fecha);
}
