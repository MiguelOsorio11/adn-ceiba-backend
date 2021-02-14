package com.ceiba.trabajodegrado.consulta;

import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.dao.DaoTrabajoDeGrado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTrabajoDeGrado {

    private final DaoTrabajoDeGrado daoTrabajoDeGrado;

    public ManejadorListarTrabajoDeGrado(DaoTrabajoDeGrado daoTrabajoDeGrado) {
        this.daoTrabajoDeGrado = daoTrabajoDeGrado;
    }

    public List<DtoTrabajoDeGrado> ejecutar(Long idUsuario){ return this.daoTrabajoDeGrado.listar(idUsuario); }
}
