package com.ceiba.trabajodegrado.consulta;

import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.dao.DaoTrabajoDeGrado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTrabajoDeGradoSinCita {

    private final DaoTrabajoDeGrado daoTrabajoDeGrado;

    public ManejadorListarTrabajoDeGradoSinCita(DaoTrabajoDeGrado daoTrabajoDeGrado) {
        this.daoTrabajoDeGrado = daoTrabajoDeGrado;
    }

    public List<DtoTrabajoDeGrado> ejecutar (){ return this.daoTrabajoDeGrado.listarTrabajosSinCitas(); }
}
