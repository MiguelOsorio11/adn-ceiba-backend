package com.ceiba.trabajodegrado.puerto.dao;

import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;

import java.util.List;

public interface DaoTrabajoDeGrado {

    List<DtoTrabajoDeGrado> listar(Long idUsuario);

    DtoTrabajoDeGrado obtener(Long idTrabajoDegRA);
}
