package com.ceiba.cita.controlador;

import com.ceiba.cita.manejador.ManejadorListarCita;
import com.ceiba.cita.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cita")
@Api(tags = "Controlador que consulta todas las citas")
public class ConsultaControladorCine {

    private final ManejadorListarCita manejadorListarCita;

    public ConsultaControladorCine(ManejadorListarCita manejadorListarCita) {
        this.manejadorListarCita = manejadorListarCita;
    }

    @GetMapping
    @ApiOperation(
            value = "Listar citas",
            notes = "Lista todas las citas almacenadass en el sistema"
    )
    public List<DtoCita> listar() {
        return this.manejadorListarCita.ejecutar();
    }
}
