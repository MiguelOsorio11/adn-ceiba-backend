package com.ceiba.trabajodegrado.servicio;

import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarTrabajoDeGradoTest {

    @Test
    public void validarEliminacionTrabajoDeGrado(){
        // arrange
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        Mockito.doNothing().when(repositorioTrabajoDeGrado).eliminar(trabajoDeGrado.getId());

        // act
        ServicioEliminarTrabajoDeGrado servicioEliminarTrabajoDeGrado = new ServicioEliminarTrabajoDeGrado(repositorioTrabajoDeGrado);
        servicioEliminarTrabajoDeGrado.ejecutar(trabajoDeGrado.getId());

        // act assert

    }
}
