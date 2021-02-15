package com.ceiba.trabajodegrado.controlador;

import com.ceiba.trabajodegrado.consulta.ManejadorListarTrabajoDeGrado;
import com.ceiba.trabajodegrado.modelo.dto.DtoTrabajoDeGrado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trabajodegrado")
@Api(tags={"Controlador consulta trabajo de grado"})
public class ConsultaControladorTrabajoDeGrado {

    private final ManejadorListarTrabajoDeGrado manejadorListarTrabajoDeGrado;

    public ConsultaControladorTrabajoDeGrado(ManejadorListarTrabajoDeGrado manejadorListarTrabajoDeGrado) {
        this.manejadorListarTrabajoDeGrado = manejadorListarTrabajoDeGrado;
    }

    @GetMapping(value = {"/{idUsuario}"} )
    @ApiOperation(
            value = "Listar trabajos de grado",
            notes = "Lista todos los paquetes turisticos existentes en el sistema")
    List<DtoTrabajoDeGrado> listar(@PathVariable Long idUsuario){
        return this.manejadorListarTrabajoDeGrado.ejecutar(idUsuario);
    }
}
