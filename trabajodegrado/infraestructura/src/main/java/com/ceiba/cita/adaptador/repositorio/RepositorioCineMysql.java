package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioCineMysql implements RepositorioCita {


    @Override
    public Long ejecutar(Cita cita) {
        return null;
    }

    @Override
    public void actualizar(Cita cita) {

    }

    @Override
    public boolean existeHoraCita(LocalDateTime horaCita) {
        return false;
    }
}
