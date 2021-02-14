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
 primary key (id)
);

Alter table trabajodegrado ADD FOREIGN KEY (id_usuario) REFERENCES usuario(id);
