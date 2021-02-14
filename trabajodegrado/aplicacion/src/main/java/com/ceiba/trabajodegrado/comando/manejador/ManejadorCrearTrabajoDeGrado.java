package com.ceiba.trabajodegrado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.comando.fabrica.FabricaTrabajoDeGrado;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioCrearTrabajoDeGrado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTrabajoDeGrado implements ManejadorComandoRespuesta<ComandoTrabajoDeGrado, ComandoRespuesta<Long>> {

    private final FabricaTrabajoDeGrado fabricaTrabajoDeGrado;
    private final ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado;

    public ManejadorCrearTrabajoDeGrado(FabricaTrabajoDeGrado fabricaTrabajoDeGrado, ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado) {
        this.fabricaTrabajoDeGrado = fabricaTrabajoDeGrado;
        this.servicioCrearTrabajoDeGrado = servicioCrearTrabajoDeGrado;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoTrabajoDeGrado comandoTrabajoDeGrado) {
        TrabajoDeGrado trabajoDeGrado = this.fabricaTrabajoDeGrado.crear(comandoTrabajoDeGrado);
        return new ComandoRespuesta<>(this.servicioCrearTrabajoDeGrado.ejecutar(trabajoDeGrado));
    }
}
