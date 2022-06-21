package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuariosService {
    public Usuario usuarioById(String id);

    public List<Usuario> listado();
    public Usuario usuario(String usuario, String password);
    public Usuario crearUsuario(Usuario usuario);
}
