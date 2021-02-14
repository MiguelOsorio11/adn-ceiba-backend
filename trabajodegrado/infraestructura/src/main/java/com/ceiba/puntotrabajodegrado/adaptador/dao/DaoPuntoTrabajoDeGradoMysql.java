package com.ceiba.puntotrabajodegrado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.puntotrabajodegrado.modelo.dto.DtoPuntoTrabajoDeGrado;
import com.ceiba.puntotrabajodegrado.puerto.dao.DaoPuntoTrabajoDeGrado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPuntoTrabajoDeGradoMysql implements DaoPuntoTrabajoDeGrado {

    private static final String NAMESPACE = "puntotrabajodegrado";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value ="listar")
    private static String slqListar;

    public DaoPuntoTrabajoDeGradoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPuntoTrabajoDeGrado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(slqListar, new MapeoPuntoTrabajoDeGrado());
    }
}
