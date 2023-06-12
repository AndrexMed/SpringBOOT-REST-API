CREATE TABLE usuarios(
    id bigint primary key,
    login varchar(100)not null unique ,
    clave varchar(300) not null
)