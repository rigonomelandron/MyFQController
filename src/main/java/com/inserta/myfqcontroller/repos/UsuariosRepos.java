package com.inserta.myfqcontroller.repos;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path="usuarios")
public interface UsuariosRepos extends JpaRepository<Usuario, String> {
     public Usuario findByUsuarioAndPass(String usuario, String pass);

}
