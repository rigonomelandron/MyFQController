package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping ("/usuarios/listado")
    public List<Usuario> listadoUsuarios (){
         return usuariosService.listado();
    }

    @GetMapping("/usuarios/user/{user}")
    public Usuario usuarioByUser(@PathVariable String user){
        return usuariosService.usuarioById(user);
    }

    @GetMapping("/usuarios/userPass/{usuario}/{pass}")

    public Usuario usuarioByUserPass(@PathVariable String usuario, @PathVariable String pass){
        return usuariosService.usuario(usuario,pass);
    }




}
