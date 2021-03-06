package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Glicada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "glicada")
public interface GlicadasRepo extends JpaRepository<Glicada, Integer> {
    public List<Glicada> findByPaciente_Dni(String dni);
    public List<Glicada> findByPaciente_DniAndFecha(String dni, Date fecha);
    public List<Glicada> findAllByFechaBetween(Date desde, Date hasta);
    public List<Glicada> findAllByPaciente_IdUsuarioAndFecha(int idUsuario, Date fecha);
}
