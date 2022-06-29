DROP DATABASE IF EXISTS MyFQController;

CREATE DATABASE MyFQController;

USE MyFQController;

CREATE TABLE usuarios (
    usuario VARCHAR(15) NOT NULL PRIMARY KEY,
    pass VARCHAR(100) NOT NULL,
    rol VARCHAR(20)
    
    
) ENGINE = INNODB;

CREATE TABLE roles (
    id INT NOT NULL PRIMARY KEY,
    rol VARCHAR(20)
) ENGINE = INNODB;

CREATE TABLE doctores(
    num_colegiado VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    email VARCHAR(30),
    id_usuario VARCHAR(15),
    FOREIGN KEY (id_usuario) REFERENCES usuarios (usuario) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE pacientes (
    dni VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    email VARCHAR(100),
    fecha_nacimiento DATE,
    genero CHAR,
    peso DECIMAL(4, 1),
    altura DECIMAL(4, 3),
    mutacion1 VARCHAR(40),
    mutacion2 VARCHAR(40),
    id_usuario VARCHAR(15),
    FOREIGN KEY (id_usuario) REFERENCES usuarios (usuario) ON DELETE CASCADE
   
) ENGINE = INNODB;

CREATE TABLE equipos (
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_paciente VARCHAR(10),
    id_medico VARCHAR(10),
    FOREIGN KEY (id_paciente) REFERENCES pacientes (dni) ON DELETE CASCADE ,
    FOREIGN KEY (id_medico) REFERENCES doctores (num_colegiado)
) ENGINE = INNODB;

CREATE TABLE antecedentes (
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dni_paciente VARCHAR(10) NOT NULL,
    fecha DATE NOT NULL,
    diagnostico VARCHAR(20),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE ciclos_antibioticos(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dni_paciente VARCHAR(10) NOT NULL,
    antibiotico VARCHAR(30),
    es_intravenoso BOOLEAN DEFAULT false,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE tratamientos_cronicos (
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dni_paciente VARCHAR(10) NOT NULL,
    descripcion VARCHAR(60),
    fecha DATE NOT NULL,
    archivo VARCHAR(50),
    oral BOOLEAN,
    inhalado BOOLEAN,
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE datos_respiratorios(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    fvc DECIMAL(3, 2),
    fev1 DECIMAL(3, 2),
    saturacion_basal DECIMAL(4, 2),
    capacidad_aerobica DECIMAL(6, 3),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE eventos(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    descripcion VARCHAR(60),
    importancia INT(2),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE deportes(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    tipo VARCHAR(30),
    calorias DECIMAL(6, 2),
    ppm_media INT(3),
    ppm_maxima INT(3),
    tiempo INT(3),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE analiticas(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    tipo VARCHAR(10),
    archivo VARCHAR(50),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE tension(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    max_tension INT(2),
    min_tension INT(2),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE glicadas(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    glicada DECIMAL(3, 2),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;

CREATE TABLE v02max(
    id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    dni_paciente VARCHAR(10) NOT NULL,
    v02max DECIMAL(5, 2),
    ppm_reposo INT(3),
    FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ENGINE = INNODB;
INSERT INTO
    roles(id, rol)
    VALUES
   
    ('1', 'paciente'),
    ('2', 'doctor');
INSERT INTO
    usuarios (usuario, pass)
VALUES
    ('Medico1', '12345'),('Medico2', '55555'),
    ('Paciente2', '11111'),
    ('Paciente', '54321');

INSERT INTO
    pacientes (
        dni,
        nombre,
        email,
        genero,
        peso,
        altura,
        mutacion1,
        mutacion2,
        id_usuario
    )
VALUES
    (
        '012345678M',
        'Paciente Prueba',
        'paciente@prueba.com',
        'h',
        76.5,
        1.87,
        'F508D',
        'G542X',
        'Paciente'
    ),
    (
        '123456789N',
        'Paciente 2 ',
        'paciente2@prueba.com',
        'm',
        54.5,
        1.47,
        'F508D',
        'F508D',
        'Paciente2'
    );

INSERT INTO
    doctores (num_colegiado, nombre, email, id_usuario)
VALUES
    (
        '0123456789',
        'Médico1',
        'medico1@correo.com',
        'Medico1'
    ),
    (
        '1234567890',
        'Médico2',
        'medico2@correo.com',
        'Medico2'
    );

INSERT INTO
    analiticas (fecha, dni_paciente, tipo, archivo)
VALUES
    ('2022-03-12', '012345678M', 'Sangre', '/ruta/'),('2018-03-12', '123456789N', 'Sangre', '/ruta/');

INSERT INTO
    antecedentes (dni_paciente, fecha, diagnostico)
VALUES
    ('012345678M', '2019-02-12', 'Endoscopia'),('123456789N', '2012-02-12', 'Bronquiectasias');

INSERT INTO
    ciclos_antibioticos (
        dni_paciente,
        antibiotico,
        es_intravenoso,
        fecha_inicio,
        fecha_fin
    )
VALUES
    (
        '012345678M',
        'Cloxacilina 500mg',
        0,
        '2021-07-21',
        '2021-08-10'
    ),
    (
        '123456789N',
        'Vancomicina',
        1,
        '2019-11-21',
        '2019-12-10'
    );

INSERT INTO
    datos_respiratorios (
        fecha,
        dni_paciente,
        fvc,
        fev1,
        saturacion_basal,
        capacidad_aerobica
    )
VALUES
    ('2022-03-19', '012345678M', 2.97, 2.30, 97, 36),('2021-12-11', '123456789N', 2.52, 2.10, 98, 32);

INSERT INTO
    deportes (
        fecha,
        dni_paciente,
        tipo,
        calorias,
        ppm_media,
        ppm_maxima,
        tiempo
    )
VALUES
    (
        '2022-05-05',
        '012345678M',
        'Ciclismo',
        540,
        138,
        164,
        70
    ),
    (
        '2021-04-04',
        '123456789N',
        'Carrera',
        320,
        140,
        159,
        30
    );

INSERT INTO
    equipos (id_paciente, id_medico)
VALUES
    ('012345678M', '0123456789'),('123456789N', '0123456789');

INSERT INTO
    eventos (fecha, dni_paciente, descripcion, importancia)
VALUES
    ('2021-08-24', '012345678M', 'Aumento de tos', 3),('2021-03-21', '123456789N', 'Fiebre alta', 5);

INSERT INTO
    glicadas (fecha, dni_paciente, glicada)
VALUES
    ('2020-03-03', '012345678M', 6.3),('2020-01-03', '123456789N', 5.4);

INSERT INTO
    tension (fecha, dni_paciente, max_tension, min_tension)
VALUES
    ('2022-05-13', '012345678M', 12.4, 7.6),('2022-05-13', '123456789N', 11.8, 6.6);

INSERT INTO
    tratamientos_cronicos (
        dni_paciente,
        descripcion,
        fecha,
        archivo,
        oral,
        inhalado
    )
VALUES
    (
        '012345678M',
        'Azitromicina',
        '2019-11-29',
        '/ruta/',
        1,
        0
    ),
    (
        '123456789N',
        'Symbicort 160mg',
        '2017-12-12',
        '/ruta/',
        0,
        1
    );

INSERT INTO
    v02max (fecha, dni_paciente, v02max, ppm_reposo)
VALUES
    ('2021-02-02', '012345678M', 98, 89),('2020-12-04', '123456789N', 97, 79);

###### 