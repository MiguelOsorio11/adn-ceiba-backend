package com.ceiba.trabajodegrado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearTrabajoDeGradoTest {

    @Test
    public void validarCreacionTrabajoDeGradoTest(){
        //arrange
        Long id = 1L;
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.when(repositorioTrabajoDeGrado.existe(trabajoDeGrado.getNombre())).thenReturn(Boolean.FALSE);
        Mockito.when(repositorioTrabajoDeGrado.ejecutar(trabajoDeGrado)).thenReturn(id);

        ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado = new ServicioCrearTrabajoDeGrado(repositorioTrabajoDeGrado);

        // act
        Long idTrabajoDeGrado =  servicioCrearTrabajoDeGrado.ejecutar(trabajoDeGrado);

        //assert
        assertEquals(id,idTrabajoDeGrado);
    }

    @Test
    public void validarTrabajoDeGradoExistenteTest(){
        //arrange
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.when(repositorioTrabajoDeGrado.existe(trabajoDeGrado.getNombre())).thenReturn(Boolean.TRUE);

        ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado = new ServicioCrearTrabajoDeGrado(repositorioTrabajoDeGrado);

        // act- arrange
        BasePrueba.assertThrows(() -> servicioCrearTrabajoDeGrado.ejecutar(trabajoDeGrado), ExcepcionDuplicidad.class, ServicioCrearTrabajoDeGrado.NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE);
    }

    @Test
    public void validarValorTrabajoDeGradoMinimoTest(){
        //arrange
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().conValorMenor().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.when(repositorioTrabajoDeGrado.existe(trabajoDeGrado.getNombre())).thenReturn(Boolean.FALSE);

        ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado = new ServicioCrearTrabajoDeGrado(repositorioTrabajoDeGrado);

        // act- arrange
        BasePrueba.assertThrows(() -> servicioCrearTrabajoDeGrado.ejecutar(trabajoDeGrado), ExcepcionValorInvalido.class, ServicioCrearTrabajoDeGrado.VALOR_MINIMO);
    }

}
