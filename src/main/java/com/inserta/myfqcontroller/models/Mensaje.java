package com.inserta.myfqcontroller.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idPaciente;
    private String idMedico;
    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String mensaje;
    private boolean isVisto;
    private String rol;
}
