package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Doctor;

import java.util.List;

public interface DoctoresService {
     List<Doctor> getDoctores();
     Doctor getDoctorByNumColegiado(String numColegiado);
     Doctor getDoctorByIdUsuario(int idUsuario);

     Doctor saveDoctor(Doctor doctor);
     Doctor modificarDoctor(Doctor doctor);
     Doctor deleteDoctor(String colegiado);
}
