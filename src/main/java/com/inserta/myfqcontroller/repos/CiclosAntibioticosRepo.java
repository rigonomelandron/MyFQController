package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.CicloAntibiotico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "ciclos-antibiotico")
public interface CiclosAntibioticosRepo extends JpaRepository<CicloAntibiotico, Integer> {
    public List<CicloAntibiotico> findByPaciente_Dni(String dni);
    public List<CicloAntibiotico> findByPaciente_DniAndFechaInicio(String dni, Date fecha);
    public List<CicloAntibiotico> findByEsIntravenosoTrue();
    public List<CicloAntibiotico> findByPaciente_IdUsuarioAndFechaInicio(int idUsuario, Date fecha);
}
