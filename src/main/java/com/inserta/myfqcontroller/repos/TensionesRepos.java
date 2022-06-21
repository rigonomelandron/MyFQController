package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Tension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path="tension")
public interface TensionesRepos extends JpaRepository<Tension, Integer> {
    public List<Tension> findByPaciente_Dni(String dni);
    public List<Tension> findByPaciente_DniAndFecha(String dni,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,pattern = "yyyy-MM-dd") Date fecha);
    public List<Tension> findAllByFechaBetween(Date desde,Date hasta);
}
