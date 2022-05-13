package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.repos.UsuariosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
     @Autowired
     private UsuariosRepos usuariosRepos;
    @RequestMapping("/")
    public String home() {
        return "login";
    }

    @PostMapping("/validar")
    public String inicioSesion(@RequestParam String user, @RequestParam String pass, HttpSession session){
        Usuario usuario = usuariosRepos.findByUsuarioAndPass(user, pass);

        if (usuario == null) {

            return "login";
        } else {
            session.setAttribute("usuario", user);
            return "home";
        }
    }



}

