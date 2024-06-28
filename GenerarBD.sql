CREATE TABLE Usuario (
    id_cod_uni CHAR(9) PRIMARY KEY,
    contraseña CHAR(8) NOT NULL,
    nro_contacto INT NOT NULL,
    correo VARCHAR(100) NOT NULL,
    rol CHAR(3) NOT NULL CHECK (rol IN ('CLI','ADM','MED')),
    estado CHAR(3) NOT NULL CHECK (estado IN ('REG','RIE','NAP')),
    reserva BOOLEAN NOT NULL
);
CREATE TABLE HistorialWeb (
    id_web INT PRIMARY KEY,
    version_web CHAR(6) NOT NULL,
    fecha_creacion DATE NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    id_cod_uni CHAR(9),
    FOREIGN KEY (id_cod_uni) REFERENCES Usuario(id_cod_uni)
);
CREATE TABLE BaseDatosTest (
    id_test SERIAL PRIMARY KEY,
    version_test CHAR(6) NOT NULL,
    fecha_test DATE NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
	id_web  INT,
	FOREIGN KEY (id_web ) REFERENCES HistorialWeb(id_web)
);
CREATE TABLE BancoDePreguntas (
    id_preg SERIAL PRIMARY KEY,
    tipo_preg CHAR(50) NOT NULL,
    fecha_creacion DATE NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);
CREATE TABLE TestPregunta (
    id_test INT NOT NULL,
    id_preg INT NOT NULL,
    peso INT NOT NULL,
    fecha_creacion DATE NOT NULL,
    PRIMARY KEY (id_test, id_preg),
	FOREIGN KEY (id_test) REFERENCES BaseDatosTest(id_test),
    FOREIGN KEY (id_preg) REFERENCES BancoDePreguntas(id_preg)
);

CREATE TABLE Organizacion (
    id_org SERIAL PRIMARY KEY,
    nombre CHAR(4) NOT NULL CHECK (nombre IN ('CEM', 'FAUA', 'FC', 'FIA', 'FIC', 'FIEECS', 'FIEE', 'FIGMM', 'FIIS', 'FIM', 'FIPP', 'FIQT')),
    encargado_org VARCHAR(50) NOT NULL,
    habilitado BOOLEAN,
	id_web  INT,
	FOREIGN KEY (id_web) REFERENCES HistorialWeb(id_web)
);
CREATE TABLE Cita (
    id_cita SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    estado CHAR(3) NOT NULL CHECK (estado IN ('ACT','RES','FAL','ASI')),
    departamento CHAR(3) NOT NULL CHECK (departamento IN ('PSI','PQT')),
    nombre_especialista VARCHAR(50) NOT NULL,
    apellido_especialista VARCHAR(50) NOT NULL,
    id_cod_uni CHAR(9),
    id_org INT,
    FOREIGN KEY (id_cod_uni) REFERENCES Usuario(id_cod_uni),
    FOREIGN KEY (id_org) REFERENCES Organizacion(id_org)
);