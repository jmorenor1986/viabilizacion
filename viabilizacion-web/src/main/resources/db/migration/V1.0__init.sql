--
--Tablas necesarias para realizar viabilizacion de credito
--

--
--Se almacenaran los datos de cada de los LOGS que sean candidatos a ser utilizados en posteriores consultas
--en el campo parametros_busq se en
--
CREATE TABLE cache_usr (
    id                  int8         not null   ,
    estado              varchar(255)            ,
    parametros_busq     varchar(255)            ,
    tipo                varchar(255)            ,
    log_id              int8                    ,
    PRIMARY KEY (id)
);
--
--Tabla en donde se almacenan los LOGS
--
CREATE TABLE log (
    id                      int8         not null   ,
    fecha                   timestamp               ,
    httpStatus              varchar(255)            ,
    tipo                    varchar(255)            ,
    traza                   TEXT                    ,
    url                     varchar(255)            ,
    usuario_micro           varchar(255) not null   ,
    principalRequest_id     int8                    ,
    servicio_id             int8                    ,
    PRIMARY KEY (id)
);
--
--
--
CREATE TABLE principal_request (
    id                  int8             not null   ,
    codigo_aliado       varchar(255)                ,
    ip_origen           varchar(255)                ,
    json                varchar(255)                ,
    usuario_aliado      varchar(255)                ,
    PRIMARY KEY (id)
);
--
--
--
CREATE TABLE servicio (
    id          int8            not null       ,
    descripcion varchar(255)                   ,
    nombre      varchar(255)                   ,
    vigencia    int8                           ,
    PRIMARY KEY (id)
);