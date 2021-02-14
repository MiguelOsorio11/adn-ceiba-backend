package com.ceiba.puntotrabajodegrado.consulta;

import com.ceiba.puntotrabajodegrado.modelo.dto.DtoPuntoTrabajoDeGrado;
import com.ceiba.puntotrabajodegrado.puerto.dao.DaoPuntoTrabajoDeGrado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPuntoTrabajoDeGrado {

    private final DaoPuntoTrabajoDeGrado daoPuntoTrabajoDeGrado;

    public ManejadorListarPuntoTrabajoDeGrado(DaoPuntoTrabajoDeGrado daoPuntoTrabajoDeGrado) {
        this.daoPuntoTrabajoDeGrado = daoPuntoTrabajoDeGrado;
    }

    public List<DtoPuntoTrabajoDeGrado> ejecutar(){ return  this.daoPuntoTrabajoDeGrado.listar(); }
}
