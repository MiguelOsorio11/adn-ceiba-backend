package com.ceiba.cita.controlador;

import com.ceiba.cita.manejador.ManejadorListarCita;
import com.ceiba.cita.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cita")
@Api(tags = "Controlador que consulta todas las citas")
public class ConsultaControladorCine {

    private final ManejadorListarCita manejadorListarCita;

    public ConsultaControladorCine(ManejadorListarCita manejadorListarCita) {
        this.manejadorListarCita = manejadorListarCita;
    }

    @GetMapping(value = "/{idUsuario}/{fechaActual}")
    @ApiOperation(
            value = "Listar citas",
            notes = "Lista todas las citas almacenadass en el sistema"
    )
    public List<DtoCita> listar(@PathVariable Long idUsuario, @PathVariable String fechaActual) {
        LocalDate fechaLocalDate = LocalDate.parse(fechaActual);
        return this.manejadorListarCita.ejecutar(idUsuario,fechaLocalDate);
    }


}
