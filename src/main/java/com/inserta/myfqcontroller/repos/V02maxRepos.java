package com.inserta.myfqcontroller.repos;



import com.inserta.myfqcontroller.models.V02max;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path="v02max")
public interface V02maxRepos extends JpaRepository<V02max, Integer> {
    public List<V02max> findByDniPaciente(String dni);
    public List<V02max> findByDniPacienteAndFecha(String dni, LocalDateTime fecha);
}
