package com.ceiba.trabajodegrado.comando.fabrica;

import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import org.springframework.stereotype.Component;

@Component
public class FabricaTrabajoDeGrado {

    public TrabajoDeGrado crear(ComandoTrabajoDeGrado comandoTrabajoDeGrado){
            return new TrabajoDeGrado(
                    comandoTrabajoDeGrado.getId(),
                    comandoTrabajoDeGrado.getIdUsuario(),
                    comandoTrabajoDeGrado.getNombre(),
                    comandoTrabajoDeGrado.getDescripcion(),
                    comandoTrabajoDeGrado.getEstado(),
                    comandoTrabajoDeGrado.getValor(),
                    comandoTrabajoDeGrado.getFechaConfirmacion()
            );
    }

}

