package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCita implements RowMapper<Cita>, MapperResult {

    @Override
    public Cita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idTrabajoDeGrado = resultSet.getLong("id_trabajo_grado");
        LocalDateTime fechaCita = extraerLocalDateTime(resultSet,"fecha_cita");

        return new Cita(id,idTrabajoDeGrado,fechaCita);
    }
}
