package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DaoCitaMysql implements DaoCita {

    private static final String NAMESPACE = "cita";

    @SqlStatement(namespace = NAMESPACE, value ="listar")
    private static String slqListar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCita> listarPorFechaYusuario(Long idUsuario, LocalDate fechaActual) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        paramSource.addValue("anhoActual", fechaActual.getYear());
        paramSource.addValue("mesActual", fechaActual.getMonthValue());
        paramSource.addValue("diaActual", fechaActual.getDayOfMonth());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(slqListar, paramSource, new MapeoCita());
    }
}
