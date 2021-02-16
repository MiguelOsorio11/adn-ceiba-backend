package com.ceiba.trabajodegrado.servicio;

import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import com.ceiba.utils.enums.MensajeGeneralEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrabajoDeGradoValidacionDominioTest {

    @Test
    public void validarIdUsuarioNullTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new TrabajoDeGradoTestDataBuilder().conIdUsuarioNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_ID_USUARIO.getMensaje(),mensajeError);
    }

    @Test
    public void validarNombreNullTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new TrabajoDeGradoTestDataBuilder().conNombreNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_DE_NOMBRE.getMensaje(),mensajeError);
    }

    @Test
    public void validarEstadoNull(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new TrabajoDeGradoTestDataBuilder().conEstadoNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_DE_ESTADO.getMensaje(),mensajeError);
    }

    @Test
    public void validarValorNull(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new TrabajoDeGradoTestDataBuilder().conValorNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_DE_VALOR.getMensaje(),mensajeError);
    }

    @Test
    public void validarValorPositivoTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new TrabajoDeGradoTestDataBuilder().conBuildExcepcionValorMenorAcero();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_VALOR_POSITIVO.getMensaje(),mensajeError);
    }

}
