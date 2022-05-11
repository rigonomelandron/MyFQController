package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.DatoRespiratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "datos-respiratorios")
public interface DatosRespiratoriosRepo extends JpaRepository<DatoRespiratorio, Integer> {
}
