package com.ceiba.trabajodegrado.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoTrabajoDeGrado implements RowMapper<TrabajoDeGrado> , MapperResult {

    @Override
    public TrabajoDeGrado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idUsuario = resultSet.getLong("id_usuario");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        String estado =  resultSet.getString("estado");
        BigDecimal valor = resultSet.getBigDecimal("valor");
        return new TrabajoDeGrado(idUsuario,nombre,descripcion,estado,valor);
    }
}
