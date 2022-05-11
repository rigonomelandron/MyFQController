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
@Table(name = "glicadas")
public class Glicada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    @Column(nullable = false)
    private String dni_paciente;
    private double glicada;
}
