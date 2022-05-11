package com.inserta.myfqcontroller.repos;

import com.inserta.myfqcontroller.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "doctores")
public interface DoctoresRepo extends JpaRepository<Doctor, String> {
}