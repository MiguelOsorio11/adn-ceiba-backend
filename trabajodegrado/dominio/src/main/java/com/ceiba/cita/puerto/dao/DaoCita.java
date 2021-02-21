package com.ceiba.cita.puerto.dao;

import com.ceiba.cita.modelo.dto.DtoCita;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DaoCita {

    List<DtoCita> listarPorFechaYusuario(Long idUsuario, LocalDate fechaActual);

}
