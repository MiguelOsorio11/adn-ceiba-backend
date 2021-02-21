package com.ceiba.trabajodegrado.consulta;

import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.dao.DaoTrabajoDeGrado;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorObtenerTrabajoDeGrado {

    private final DaoTrabajoDeGrado daoTrabajoDeGrado;

    public ManejadorObtenerTrabajoDeGrado(DaoTrabajoDeGrado daoTrabajoDeGrado) {
        this.daoTrabajoDeGrado = daoTrabajoDeGrado;
    }

    public DtoTrabajoDeGrado ejecutar(Long idTrabajoDeUsuario){ return this.daoTrabajoDeGrado.obtener(idTrabajoDeUsuario); }
}
