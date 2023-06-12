CREATE TABLE medicos(
                        id bigint not null identity(1,1) primary key,
                        nombre nvarchar(80)not null unique,
                        email nvarchar(80)not null unique,
                        documento nvarchar(10)not null unique,
                        telefono nvarchar (20) not null unique,
                        especialidad nvarchar(80)not null,
                        calle nvarchar(80)not null,
                        distrito nvarchar(80) not null,
                        complemento nvarchar(80)not null,
                        numero nvarchar(20) not null,
                        ciudad nvarchar(80) not null,
                        activo tinyint
)