package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.DatoRespiratorio;
import com.inserta.myfqcontroller.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "datos-respiratorios")
public interface DatosRespiratoriosRepo extends JpaRepository<DatoRespiratorio, Integer> {
    public List<DatoRespiratorio> findByPaciente_Dni(String dni);
    public List<DatoRespiratorio> findByPaciente_DniAndFecha(String dni, Date fecha);
    public List<DatoRespiratorio> findAllByPaciente_IdUsuarioAndFechaBetween(String idUsuario ,Date desde, Date hasta);
     public List<DatoRespiratorio> findAllByPaciente_DniAndFecha(String dni, Date fecha);
    public List<DatoRespiratorio> findAllByPaciente_IdUsuarioEqualsAndFecha(String idUsuario, Date fecha);
    public List<DatoRespiratorio> findAllByPaciente_IdUsuario(String idUsuario);

}
