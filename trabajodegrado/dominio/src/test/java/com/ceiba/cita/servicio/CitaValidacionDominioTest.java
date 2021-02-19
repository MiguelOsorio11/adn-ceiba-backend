package com.ceiba.cita.servicio;

import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import com.ceiba.utils.enums.MensajeGeneralEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitaValidacionDominioTest {

    @Test
    public void validarIdTrabajoDeGradoNullTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new CitaTestDataBuilder().conIdTrabajoDeGradoNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_ID_TRABAJO_DE_GRADO.getMensaje(),mensajeError);
    }

    @Test
    public void validarFechaConfirmacionNullTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new CitaTestDataBuilder().conFechaNull();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.INGRESO_FECHA_CITA.getMensaje(),mensajeError);
    }

    @Test
    public void validarFechaConfirmacionMenorActualTest(){
        // assert
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            new CitaTestDataBuilder().conFechaConfirmacionMenorActual();
        });
        // act
        String mensajeError = excepcion.getMessage();
        // arrange
        assertEquals(MensajeGeneralEnum.FECHA_CITA_MENOR_ACTUAL.getMensaje(),mensajeError);
    }
}
