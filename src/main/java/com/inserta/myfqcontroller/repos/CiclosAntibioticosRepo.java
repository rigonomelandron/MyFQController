package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.CicloAntibiotico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "ciclos-antibiotico")
public interface CiclosAntibioticosRepo extends JpaRepository<CicloAntibiotico, Integer> {
    public List<CicloAntibiotico> findByDniPaciente(String dni);
    public List<CicloAntibiotico> findByDniPacienteAndFechaInicio(String dni, LocalDateTime fecha);
    public List<CicloAntibiotico> findByEsIntravenosoTrue();
}
