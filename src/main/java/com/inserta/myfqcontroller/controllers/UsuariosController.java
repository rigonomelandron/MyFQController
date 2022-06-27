package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.services.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("/usuario/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario){

        return usuariosService.crearUsuario(usuario);
    }





}
