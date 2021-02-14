package com.ceiba.trabajodegrado.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.trabajodegrado.servicio.ServicioEliminarTrabajoDeGrado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTrabajoDeGrado  implements ManejadorComando<Long> {

    private final ServicioEliminarTrabajoDeGrado servicioEliminarTrabajoDeGrado;

    public ManejadorEliminarTrabajoDeGrado(ServicioEliminarTrabajoDeGrado servicioEliminarTrabajoDeGrado) {
        this.servicioEliminarTrabajoDeGrado = servicioEliminarTrabajoDeGrado;
    }

    @Override
    public void ejecutar(Long idTrabajoDeGrado) {
        this.servicioEliminarTrabajoDeGrado.ejecutar(idTrabajoDeGrado);
    }
}
