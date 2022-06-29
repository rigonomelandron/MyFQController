package com.inserta.myfqcontroller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "antecedentes")
public class Antecedente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "dni_paciente", referencedColumnName = "dni")
    private Paciente paciente;
    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String diagnostico;

}
