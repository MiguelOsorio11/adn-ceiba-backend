package com.ceiba.trabajodegrado.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.comando.fabrica.FabricaTrabajoDeGrado;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioActualizarTrabajoDeGrado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTrabajoDeGrado implements ManejadorComando<ComandoTrabajoDeGrado> {

    private final FabricaTrabajoDeGrado fabricaTrabajoDeGrado;
    private final ServicioActualizarTrabajoDeGrado servicioActualizarTrabajoDeGrado;

    public ManejadorActualizarTrabajoDeGrado(FabricaTrabajoDeGrado fabricaTrabajoDeGrado, ServicioActualizarTrabajoDeGrado servicioActualizarTrabajoDeGrado) {
        this.fabricaTrabajoDeGrado = fabricaTrabajoDeGrado;
        this.servicioActualizarTrabajoDeGrado = servicioActualizarTrabajoDeGrado;
    }

    @Override
    public void ejecutar(ComandoTrabajoDeGrado comandoTrabajoDeGrado) {
        TrabajoDeGrado trabajoDeGrado = this.fabricaTrabajoDeGrado.crear(comandoTrabajoDeGrado);
        this.servicioActualizarTrabajoDeGrado.ejecutar(comandoTrabajoDeGrado.getId(),trabajoDeGrado, comandoTrabajoDeGrado.getFechaConfirmacion());
    }
}
