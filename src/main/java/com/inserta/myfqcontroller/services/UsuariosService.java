package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuariosService {
   Usuario usuarioById( int id);
   List<Usuario> listado();

   Usuario crearUsuario(Usuario usuario);

   Usuario usuarioByUser(String user);
}
