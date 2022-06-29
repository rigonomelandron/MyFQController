package com.inserta.myfqcontroller.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    private String usuario;
    private String pass;
    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id")
    private Rol rol;
    private String foto;



}
