package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.repos.UsuariosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuariosRepos usuariosRepos;
    @RequestMapping ("/login")
    public String login(@RequestParam String dni, @RequestParam String pass, HttpSession session){

        Usuario user = usuariosRepos.findByUsuarioAndPass(dni, pass);
        System.out.println(user);
        if(user == null){
            return  "login";
        }else{
            session.setAttribute("usuario", user);

            return "home";
        }
    }

}
