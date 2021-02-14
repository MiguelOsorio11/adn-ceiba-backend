package com.ceiba.configuracion;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioActualizarTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioCrearTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.ServicioEliminarTrabajoDeGrado;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    //=============   SERVICIOS USUARIO ===================

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    //======================================================

    //=============   SERVICIOS TRABAJO DE GRADO ===================

    @Bean
    public ServicioCrearTrabajoDeGrado servicioCrearTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado){
        return new ServicioCrearTrabajoDeGrado(repositorioTrabajoDeGrado);
    }

    @Bean
    public ServicioActualizarTrabajoDeGrado servicioActualizarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado){
        return new ServicioActualizarTrabajoDeGrado(repositorioTrabajoDeGrado);
    }

    @Bean
    public ServicioEliminarTrabajoDeGrado servicioEliminarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado){
        return new ServicioEliminarTrabajoDeGrado(repositorioTrabajoDeGrado);
    }

    //======================================================

    //=============   SERVICIOS CITA ===================

    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCine){
        return new ServicioCrearCita(repositorioCine);
    }
	
}
