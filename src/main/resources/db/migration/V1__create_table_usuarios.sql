create table if not exists usuarios(
    id bigint not null auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    email varchar(200) not null unique,
    telefono varchar(40) not null,
    password varchar(200) not null,

    primary key(id)
);