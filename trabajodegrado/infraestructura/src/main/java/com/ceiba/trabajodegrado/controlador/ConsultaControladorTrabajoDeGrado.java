package com.ceiba.trabajodegrado.controlador;

import com.ceiba.trabajodegrado.consulta.ManejadorListarTrabajoDeGrado;
import com.ceiba.trabajodegrado.consulta.ManejadorObtenerTrabajoDeGrado;
import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajodegrado")
@Api(tags={"Controlador consulta trabajo de grado"})
public class ConsultaControladorTrabajoDeGrado {

    private final ManejadorListarTrabajoDeGrado manejadorListarTrabajoDeGrado;
    private final ManejadorObtenerTrabajoDeGrado manejadorObtenerTrabajoDeGrado;

    public ConsultaControladorTrabajoDeGrado(ManejadorListarTrabajoDeGrado manejadorListarTrabajoDeGrado, ManejadorObtenerTrabajoDeGrado manejadorObtenerTrabajoDeGrado) {
        this.manejadorListarTrabajoDeGrado = manejadorListarTrabajoDeGrado;
        this.manejadorObtenerTrabajoDeGrado = manejadorObtenerTrabajoDeGrado;
    }

    @GetMapping(value = {"/{idUsuario}"} )
    @ApiOperation(
            value = "Listar trabajos de grado",
            notes = "Lista todos los paquetes turisticos existentes en el sistema")
    public List<DtoTrabajoDeGrado> listar(@PathVariable Long idUsuario){
        return this.manejadorListarTrabajoDeGrado.ejecutar(idUsuario);
    }

    @GetMapping(value = {"/obtener/{idTrabajoDeGrado}"} )
    @ApiOperation(
            value = "Obtener trabajo de grado",
            notes = "Obtiene un trabajo de grado en el sistema")
    public DtoTrabajoDeGrado obtener(@PathVariable Long idTrabajoDeGrado){
        return this.manejadorObtenerTrabajoDeGrado.ejecutar(idTrabajoDeGrado);
    }
}
