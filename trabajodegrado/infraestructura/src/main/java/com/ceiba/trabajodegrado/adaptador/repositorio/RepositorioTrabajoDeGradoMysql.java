package com.ceiba.trabajodegrado.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioTrabajoDeGradoMysql implements RepositorioTrabajoDeGrado {

    private static final String NAMESPACE = "trabajodegrado";
    private static final String NAME_TAG ="nombre";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = NAMESPACE, value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = NAMESPACE, value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = NAMESPACE, value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = NAMESPACE, value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = NAMESPACE, value = "detallar")
    private static String sqlDetalle;

    @SqlStatement(namespace = NAMESPACE, value = "cancelar")
    private static String sqlCancelarTrabajo;

    public RepositorioTrabajoDeGradoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long ejecutar(TrabajoDeGrado trabajoDeGrado) {
        return this.customNamedParameterJdbcTemplate.crear(trabajoDeGrado, sqlCrear);
    }

    @Override
    public void actualizar(Long idTrabajoDeGrado, TrabajoDeGrado trabajoDeGrado, LocalDateTime fechaConfirmacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idTrabajoDeGrado);
        paramSource.addValue("fechaConfirmacion", fechaConfirmacion);
        paramSource.addValue("idUsuario", trabajoDeGrado.getIdUsuario());
        paramSource.addValue(NAME_TAG, trabajoDeGrado.getNombre());
        paramSource.addValue("descripcion", trabajoDeGrado.getDescripcion());
        paramSource.addValue("estado", trabajoDeGrado.getEstado());
        paramSource.addValue("valor", trabajoDeGrado.getValor());

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
    }

    @Override
    public void eliminar(Long idTrabajoDeGrado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTrabajoDeGrado", idTrabajoDeGrado);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(NAME_TAG, nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource,Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue(NAME_TAG, nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource,Boolean.class);
    }


    @Override
    public TrabajoDeGrado obtener(Long idTrabajoDeGrado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTrabajoDeGrado", idTrabajoDeGrado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDetalle, paramSource, new MapeoTrabajoDeGrado());
    }

    @Override
    public void cancelar(Long id, EstadoTrabajoDeGradoEnum estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("estado", estado.getMensaje());

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCancelarTrabajo, paramSource);
    }
}
