package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Antecedente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "antecedentes")
public interface AntecedentesRepo extends JpaRepository<Antecedente, Integer> {
}
