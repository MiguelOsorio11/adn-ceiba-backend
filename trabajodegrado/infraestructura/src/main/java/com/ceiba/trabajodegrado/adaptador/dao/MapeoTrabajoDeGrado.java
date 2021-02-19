package com.ceiba.trabajodegrado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoTrabajoDeGrado implements RowMapper<DtoTrabajoDeGrado>, MapperResult {

    @Override
    public DtoTrabajoDeGrado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idUsuario = resultSet.getLong("id_usuario");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        String estado = resultSet.getString("estado");
        BigDecimal valor = resultSet.getBigDecimal("valor");
        LocalDateTime fechaConfirmacion = extraerLocalDateTime(resultSet,"fecha_confirmacion");

        return new DtoTrabajoDeGrado(id,idUsuario,nombre,descripcion,estado,valor,fechaConfirmacion);
    }

}
