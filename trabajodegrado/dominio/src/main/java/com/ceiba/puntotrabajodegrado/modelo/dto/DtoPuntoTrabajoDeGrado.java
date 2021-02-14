package com.ceiba.puntotrabajodegrado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoPuntoTrabajoDeGrado {

    private Long id;
    private String nombre;
    private BigDecimal valor;
}
