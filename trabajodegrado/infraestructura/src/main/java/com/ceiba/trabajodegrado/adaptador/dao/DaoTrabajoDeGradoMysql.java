package com.ceiba.trabajodegrado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.dao.DaoTrabajoDeGrado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTrabajoDeGradoMysql implements DaoTrabajoDeGrado {

    private static final String NAMESPACE = "trabajodegrado";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value ="listarPorUsuario")
    private static String slqListar;

    public DaoTrabajoDeGradoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTrabajoDeGrado> listar(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(slqListar, paramSource, new MapeoTrabajoDeGrado());
    }
}
