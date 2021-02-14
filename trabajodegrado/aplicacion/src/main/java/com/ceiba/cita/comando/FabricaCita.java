package com.ceiba.cita.comando;

import com.ceiba.cita.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crear(ComandoCita comandoCita){
        return new Cita(
                comandoCita.getId(),
                comandoCita.getIdTrabajoDeGrado(),
                comandoCita.getFechaCita()
        );
    }
}
