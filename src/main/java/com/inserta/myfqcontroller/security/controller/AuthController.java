package com.inserta.myfqcontroller.security.controller;

import com.inserta.myfqcontroller.dto.Message;
import com.inserta.myfqcontroller.models.Rol;
import com.inserta.myfqcontroller.models.Usuario;
import com.inserta.myfqcontroller.security.dto.JwtDto;
import com.inserta.myfqcontroller.security.dto.LoginUsuario;
import com.inserta.myfqcontroller.security.dto.NuevoUsuario;
import com.inserta.myfqcontroller.security.enums.RolNombre;
import com.inserta.myfqcontroller.security.jwt.JwtProvider;
import com.inserta.myfqcontroller.security.service.RolService;
import com.inserta.myfqcontroller.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public Usuario nuevo(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){

        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("ROLE_MEDICO")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_MEDICO).get());
        }
        if(nuevoUsuario.getRoles().contains("ROLE_PACIENTE"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_PACIENTE).get());
        usuario.setRol(roles);

        return usuarioService.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}

