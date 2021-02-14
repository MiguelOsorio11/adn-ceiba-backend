package com.ceiba.cita;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

    private Long id;
    private Long idUsuario;
    private LocalDateTime fechaCita;
}
