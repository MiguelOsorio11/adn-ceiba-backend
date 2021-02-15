package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cita.ComandoCita;
import com.ceiba.cita.servicio.testdatabuilder.ComandoCitaTestDataBuilder;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.ComandoTrabajoDeGradoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCita.class)
@AutoConfigureMockMvc(addFilters = false)
public class ComandoControladorCitaTest {

    private static final String URL_CITA = "/cita";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoCita comandoCita = new ComandoCitaTestDataBuilder().build();

        // act - assert
        mockMvc.perform(post(URL_CITA)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(comandoCita)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
}
