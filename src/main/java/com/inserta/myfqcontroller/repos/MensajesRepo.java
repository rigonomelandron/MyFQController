package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(path = "mensajes")
public interface MensajesRepo extends JpaRepository<Mensaje, Integer> {
        List<Mensaje> findAllByIdPaciente(String idPaciente);
        List<Mensaje> findAllByIdPacienteAndFecha(String dni, Date fecha);
        List<Mensaje> findAllByIdMedicoAndFecha(String idUsuario, Date fecha);
        List<Mensaje> findAllByIdMedico(String idMedico);
}
