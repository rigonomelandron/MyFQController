package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsuariosServicesImpl implements  UsuariosService{

    @Autowired
    private UsuarioRepository usuariosRepos;

    @Override
    public Usuario usuarioById(int usuario) {
        return usuariosRepos.findById(usuario).orElse(null);
    }

    @Override
    public List<Usuario> listado() {
        return usuariosRepos.findAll();
    }



    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuariosRepos.save(usuario);
    }

    @Override
    public Usuario usuarioByUser(String user) {
        return usuariosRepos.findByNombreUsuario(user).orElse(null);
    }
}
