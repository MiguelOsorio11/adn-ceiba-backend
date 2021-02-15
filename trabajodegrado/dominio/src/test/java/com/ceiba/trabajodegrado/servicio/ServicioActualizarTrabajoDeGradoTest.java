package com.ceiba.trabajodegrado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarTrabajoDeGradoTest {

    @Test
    public void validarTrabajoDeGradoExistiaPreviaTest(){
        //arrange
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.when(repositorioTrabajoDeGrado.existeExcluyendoId(trabajoDeGrado.getId(), trabajoDeGrado.getNombre())).thenReturn(Boolean.TRUE);

        ServicioActualizarTrabajoDeGrado servicioActualizarTrabajoDeGrado = new ServicioActualizarTrabajoDeGrado(repositorioTrabajoDeGrado);
        // act- arrange
        BasePrueba.assertThrows(() -> servicioActualizarTrabajoDeGrado.ejecutar(trabajoDeGrado), ExcepcionDuplicidad.class, ServicioActualizarTrabajoDeGrado.NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE);
    }

    @Test
    public void validacionActualizacionTrabajoDeGradoTest(){
        //arrange
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.when(repositorioTrabajoDeGrado.existeExcluyendoId(trabajoDeGrado.getId(), trabajoDeGrado.getNombre())).thenReturn(Boolean.FALSE);

        //act - arrange
        ServicioActualizarTrabajoDeGrado servicioActualizarTrabajoDeGrado = new ServicioActualizarTrabajoDeGrado(repositorioTrabajoDeGrado);
        servicioActualizarTrabajoDeGrado.ejecutar(trabajoDeGrado);
    }

}
