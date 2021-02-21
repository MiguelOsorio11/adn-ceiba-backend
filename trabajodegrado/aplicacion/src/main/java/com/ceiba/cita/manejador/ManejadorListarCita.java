package com.ceiba.cita.manejador;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ManejadorListarCita {

    private final DaoCita daoCita;

    public ManejadorListarCita(DaoCita daoCita) {
        this.daoCita = daoCita;
    }

    public List<DtoCita> ejecutar(Long idUsuario, LocalDate fechaActual){ return this.daoCita.listarPorFechaYusuario(idUsuario,fechaActual); }

}
