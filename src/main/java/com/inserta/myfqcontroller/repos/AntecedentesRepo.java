package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.CicloAntibiotico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "antecedentes")
public interface AntecedentesRepo extends JpaRepository<Antecedente, Integer> {
    public List<Antecedente> findByPaciente_Dni(String dni);
    public List<Antecedente> findByPaciente_DniAndFecha(String dni, Date fecha);
}
