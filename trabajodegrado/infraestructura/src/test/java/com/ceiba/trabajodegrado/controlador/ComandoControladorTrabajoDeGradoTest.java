package com.ceiba.trabajodegrado.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.ComandoTrabajoDeGradoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorTrabajoDeGrado.class)
@AutoConfigureMockMvc(addFilters = false)
public class ComandoControladorTrabajoDeGradoTest {

    private static final String URL_TRABAJO_GRADO = "/trabajodegrado";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoTrabajoDeGrado comandoTrabajoDeGrado = new ComandoTrabajoDeGradoTestDataBuilder().build();

        // act - assert
        mockMvc.perform(post(URL_TRABAJO_GRADO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(comandoTrabajoDeGrado)))
                        .andExpect(status().isOk())
                        .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        ComandoTrabajoDeGrado comandoTrabajoDeGrado = new ComandoTrabajoDeGradoTestDataBuilder().conDescripcion("descripcion").build();

        // act - assert
        mockMvc.perform(put(URL_TRABAJO_GRADO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTrabajoDeGrado)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mockMvc.perform(delete(URL_TRABAJO_GRADO+"/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void cancelar() throws Exception{

        // arrange
        LocalDateTime fechaConfirmacion = LocalDateTime.of(2021,02,19,10,10);
        ComandoTrabajoDeGrado comandoTrabajoDeGrado = new ComandoTrabajoDeGradoTestDataBuilder().conFechaConfirmacion(fechaConfirmacion).build();

        // act - assert
        mockMvc.perform(put(URL_TRABAJO_GRADO+"/cancelar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTrabajoDeGrado)))
                .andExpect(status().isOk());
    }

}
