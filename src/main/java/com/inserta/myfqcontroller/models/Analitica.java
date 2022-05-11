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
@Table(name = "analiticas")
public class Analitica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    @Column(nullable = false)
    private String dni_paciente;
    private String tipo;
    private String archivo;
}
