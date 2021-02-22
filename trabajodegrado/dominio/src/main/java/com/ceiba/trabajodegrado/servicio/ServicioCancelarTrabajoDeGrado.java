package com.ceiba.trabajodegrado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCancelacionTrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class ServicioCancelarTrabajoDeGrado {

    public static final String CANCELACION_INVALIDA ="No se puede cancelar el trabajo de grado debido a que ya sobre paso las 24 h despues de su confirmacion";

    private final RepositorioTrabajoDeGrado repositorioTrabajoDeGrado;

    public ServicioCancelarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado) {
        this.repositorioTrabajoDeGrado = repositorioTrabajoDeGrado;
    }

    public void ejecutar(Long idTrabajoDeGrado, EstadoTrabajoDeGradoEnum estado, LocalDateTime fechaConfirmacion){
        validarFechaConfirmacionNoMayor24Horas(fechaConfirmacion);
        this.repositorioTrabajoDeGrado.cancelar(idTrabajoDeGrado,estado);
    }

    private void validarFechaConfirmacionNoMayor24Horas(LocalDateTime fechaConfirmacion){

        LocalDateTime fechaAhora = LocalDateTime.now();
        LocalDateTime fechaActualSinSegundos = LocalDateTime.of(fechaAhora.getYear(),fechaAhora.getMonth(),fechaAhora.getDayOfMonth(),fechaAhora.getHour(),fechaAhora.getMinute());
        //fechaConfirmacion.atOffset(zoneOffset);
        long horaFechaAhora = TimeUnit.MILLISECONDS.toHours(fechaActualSinSegundos.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        long horaFechaConfirmacion = TimeUnit.MILLISECONDS.toHours(fechaConfirmacion.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        long operacion = Math.abs( horaFechaAhora - horaFechaConfirmacion);
        if(operacion > 24)
            throw new ExcepcionCancelacionTrabajoDeGrado(CANCELACION_INVALIDA);
    }

}
