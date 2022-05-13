package com.inserta.myfqcontroller.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deportes")
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    @Column(nullable = false)
    private String dniPaciente;
    private String tipo;
    private float calorias;
    private int ppmMaxima;
    private int tiempo;
}
