package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idTrabajoDeGrado = resultSet.getLong("id_trabajo_grado");
        LocalDateTime fechaCita = extraerLocalDateTime(resultSet,"fecha_cita");

        return new DtoCita(id,idTrabajoDeGrado,fechaCita);
    }
}
