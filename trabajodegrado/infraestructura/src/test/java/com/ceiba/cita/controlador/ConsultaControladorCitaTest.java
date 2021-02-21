package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.puntotrabajodegrado.controlador.ConsultaControladorPuntoTrabajoDeGrado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorCine.class)
public class ConsultaControladorCitaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        //arrenge

        //act - assert
        mockMvc.perform(get("/cita/1/2021-03-11")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
