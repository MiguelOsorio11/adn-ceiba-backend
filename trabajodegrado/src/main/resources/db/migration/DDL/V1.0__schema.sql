create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table puntotrabajodegrado (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 valor decimal(16,4) not null,
 primary key (id)
);

create table trabajodegrado (
 id int(11) not null auto_increment,
 id_usuario int(11) not null,
 nombre varchar(100) not null,
 descripcion varchar(500),
 estado varchar(100) not null,
 valor decimal(16,4) not null,
 fecha_confirmacion datetime,
 primary key (id),
 CONSTRAINT UC_TrabajoDeGrado UNIQUE (id,nombre)
);

Alter table trabajodegrado ADD FOREIGN KEY (id_usuario) REFERENCES usuario(id);

create table cita (
 id int(11) not null auto_increment,
 id_trabajo_grado int(11) not null,
 fecha_cita datetime not null,
 primary key(id)
);

Alter table cita ADD FOREIGN KEY (id_trabajo_grado) REFERENCES trabajodegrado(id);
