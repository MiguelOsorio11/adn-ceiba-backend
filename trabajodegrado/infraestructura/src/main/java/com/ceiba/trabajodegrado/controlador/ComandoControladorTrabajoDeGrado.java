package com.ceiba.trabajodegrado.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.trabajodegrado.comando.manejador.ManejadorActualizarTrabajoDeGrado;
import com.ceiba.trabajodegrado.comando.manejador.ManejadorCrearTrabajoDeGrado;
import com.ceiba.trabajodegrado.comando.manejador.ManejadorEliminarTrabajoDeGrado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trabajodegrado")
@Api(tags = {"Controlador del comando  de trabajo de grado"})
public class ComandoControladorTrabajoDeGrado {

    private ManejadorCrearTrabajoDeGrado manejadorCrearTrabajoDeGrado;
    private ManejadorEliminarTrabajoDeGrado manejadorEliminarTrabajoDeGrado;
    private ManejadorActualizarTrabajoDeGrado manejadorActualizarTrabajoDeGrado;

    @Autowired
    public ComandoControladorTrabajoDeGrado(ManejadorCrearTrabajoDeGrado manejadorCrearTrabajoDeGrado,
                                            ManejadorEliminarTrabajoDeGrado manejadorEliminarTrabajoDeGrado,
                                            ManejadorActualizarTrabajoDeGrado manejadorActualizarTrabajoDeGrado) {
        this.manejadorCrearTrabajoDeGrado = manejadorCrearTrabajoDeGrado;
        this.manejadorEliminarTrabajoDeGrado = manejadorEliminarTrabajoDeGrado;
        this.manejadorActualizarTrabajoDeGrado = manejadorActualizarTrabajoDeGrado;
    }

    @PostMapping
    @ApiOperation(
            value = "Crear trabajo de grado",
            notes = "Realiza la creación de un trabajo de grado en el sistema"
    )
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTrabajoDeGrado comandoTrabajoDeGrado) {
        return this.manejadorCrearTrabajoDeGrado.ejecutar(comandoTrabajoDeGrado);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Eliminar trabajo de grado",
            notes = "Elimina un trabajo de grado del sistema"
    )
    public void eliminar(@PathVariable Long id) { this.manejadorEliminarTrabajoDeGrado.ejecutar(id); }

    @PutMapping
    @ApiOperation(
            value = "Actualizar trabajo de grado",
            notes = "Realiza la actualizacion del trabajo de grado en el sistema")
    public void actualizar(@RequestBody ComandoTrabajoDeGrado comandoTrabajoDeGrado){
        this.manejadorActualizarTrabajoDeGrado.ejecutar(comandoTrabajoDeGrado);
    }

}
