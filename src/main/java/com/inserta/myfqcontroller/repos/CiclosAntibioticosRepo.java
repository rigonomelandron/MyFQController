package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.CicloAntibiotico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "ciclos-antibiotico")
public interface CiclosAntibioticosRepo extends JpaRepository<CicloAntibiotico, Integer> {
}
