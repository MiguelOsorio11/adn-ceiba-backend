package com.ceiba.puntotrabajodegrado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.puntotrabajodegrado.modelo.dto.DtoPuntoTrabajoDeGrado;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPuntoTrabajoDeGrado implements RowMapper<DtoPuntoTrabajoDeGrado>, MapperResult {

    @Override
    public DtoPuntoTrabajoDeGrado mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        BigDecimal valor = resultSet.getBigDecimal("valor");
        return new DtoPuntoTrabajoDeGrado(id,nombre,valor);
    }
}
