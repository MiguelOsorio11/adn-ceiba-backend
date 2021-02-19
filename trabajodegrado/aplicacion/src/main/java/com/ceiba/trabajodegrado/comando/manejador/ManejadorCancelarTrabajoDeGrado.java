package com.ceiba.trabajodegrado.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioCancelarTrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCancelarTrabajoDeGrado implements ManejadorComando<ComandoTrabajoDeGrado>  {

    private final ServicioCancelarTrabajoDeGrado servicioCancelarTrabajoDeGrado;

    public ManejadorCancelarTrabajoDeGrado(ServicioCancelarTrabajoDeGrado servicioCancelarTrabajoDeGrado) {
        this.servicioCancelarTrabajoDeGrado = servicioCancelarTrabajoDeGrado;
    }

    @Override
    public void ejecutar(ComandoTrabajoDeGrado comandoTrabajoDeGrado) {
        this.servicioCancelarTrabajoDeGrado.ejecutar(comandoTrabajoDeGrado.getId(),EstadoTrabajoDeGradoEnum.CANCELADO,comandoTrabajoDeGrado.getFechaConfirmacion());
    }

}
