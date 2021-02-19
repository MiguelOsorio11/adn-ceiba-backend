package com.ceiba.puntotrabajodegrado.controlador;

import com.ceiba.puntotrabajodegrado.consulta.ManejadorListarPuntoTrabajoDeGrado;
import com.ceiba.puntotrabajodegrado.modelo.dto.DtoPuntoTrabajoDeGrado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/puntostrabajodegrado")
@Api(tags = "Controlador que consulta los puntos que pueden tener un trabajo de grado")
public class ConsultaControladorPuntoTrabajoDeGrado {

    private final ManejadorListarPuntoTrabajoDeGrado manejadorListarPuntoTrabajoDeGrado;

    public ConsultaControladorPuntoTrabajoDeGrado(ManejadorListarPuntoTrabajoDeGrado manejadorListarPuntoTrabajoDeGrado) {
        this.manejadorListarPuntoTrabajoDeGrado = manejadorListarPuntoTrabajoDeGrado;
    }

    @GetMapping
    @ApiOperation(
            value = "Listar puntos de un trabajo de grado",
            notes = "Lista todos los puntos de un trabajo de grado almacenados en el sistema"
    )
    public List<DtoPuntoTrabajoDeGrado> listar() {
        return this.manejadorListarPuntoTrabajoDeGrado.ejecutar();
    }
}
