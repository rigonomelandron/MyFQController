package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuariosService {
   Usuario usuarioById(String id);
   List<Usuario> listado();
   Usuario usuario(String usuario, String password);
   Usuario crearUsuario(Usuario usuario);
}
