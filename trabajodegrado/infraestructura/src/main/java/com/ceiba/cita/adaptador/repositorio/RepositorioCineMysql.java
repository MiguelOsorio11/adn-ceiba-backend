package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioCineMysql implements RepositorioCita {

    private static final String NAMESPACE = "cita";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = NAMESPACE, value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = NAMESPACE, value = "existeCitaDiaHora")
    private static String sqlExisteCitaDiaHora;

    public RepositorioCineMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long ejecutar(Cita cita) {

        return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
    }

    @Override
    public void actualizar(Cita cita) {
        this.customNamedParameterJdbcTemplate.actualizar(cita,sqlActualizar);
    }

    @Override
    public boolean existeHoraCita(LocalDateTime fechaCita) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCita", fechaCita);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCitaDiaHora, paramSource,Boolean.class);
    }
}
