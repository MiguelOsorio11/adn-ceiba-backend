insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into puntotrabajodegrado (nombre, valor) values ('Ante proyecto',50000);

insert into trabajodegrado(id_usuario, nombre,descripcion,estado,valor)  values(1,'Aplicacion movil','trabajo de grado', 'EN_ESPERA',200000);

insert into cita (id_trabajo_grado,fecha_cita) values (1,'2021-02-15 10:30:00');
