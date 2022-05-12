package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.repos.UsuariosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicesImpl implements  UsuariosService{

    @Autowired
    private UsuariosRepos usuariosRepos;

    @Override
    public Usuario usuarioById(String usuario) {
        return usuariosRepos.findById(usuario).orElse(null);
    }

    @Override
    public List<Usuario> listado() {
        return usuariosRepos.findAll();
    }

    @Override
    public Usuario usuario(String usuario, String password) {
        return usuariosRepos.findByUsuarioAndPass(usuario,password);
    }
}
