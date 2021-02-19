package com.ceiba.cita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.ComandoCita;
import com.ceiba.cita.manejador.ManejadorCrearCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cita")
@Api(tags = {"Controlador del comando  de cita"})
public class ComandoControladorCita {

    private ManejadorCrearCita manejadorCrearCita;

    @Autowired
    public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita) {
        this.manejadorCrearCita = manejadorCrearCita;
    }

    @PostMapping
    @ApiOperation(
            value = "Crear cita",
            notes = "Realiza la creación de una cita en el sistema"
    )
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
        return this.manejadorCrearCita.ejecutar(comandoCita);
    }

}
