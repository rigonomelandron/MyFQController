DROP DATABASE IF EXISTS MyFQControllerV2;

CREATE DATABASE MyFQControllerV2;

USE MyFQControllerV2;

CREATE TABLE
    usuario (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nombre_usuario VARCHAR(255) NOT NULL,
        nombre VARCHAR(255) NOT NULL,
        password VARCHAR(100) NOT NULL,
        foto VARCHAR(200),
        email VARCHAR(255)
    ) ENGINE = INNODB;

CREATE TABLE
    rol (
        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        rol_nombre VARCHAR(255)
    ) ENGINE = INNODB;

CREATE TABLE
    usuario_rol(
        usuario_id INT NOT NULL,
        rol_id INT NOT NULL,
        PRIMARY KEY (usuario_id, rol_id),
        FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE,
        FOREIGN KEY (rol_id) REFERENCES rol (id)
    ) ENGINE = INNODB;

CREATE TABLE
    doctores(
        num_colegiado VARCHAR(10) NOT NULL PRIMARY KEY,
        nombre VARCHAR(30) NOT NULL,
        email VARCHAR(30),
        id_usuario int,
        FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    pacientes (
        dni VARCHAR(10) NOT NULL PRIMARY KEY,
        nombre VARCHAR(30) NOT NULL,
        email VARCHAR(100),
        fecha_nacimiento DATE,
        genero CHAR,
        peso DECIMAL(4, 1),
        altura DECIMAL(4, 3),
        mutacion1 VARCHAR(40),
        mutacion2 VARCHAR(40),
        id_usuario int,
        FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    equipos (
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        id_paciente VARCHAR(10),
        id_medico VARCHAR(10),
        FOREIGN KEY (id_paciente) REFERENCES pacientes (dni) ON DELETE CASCADE,
        FOREIGN KEY (id_medico) REFERENCES doctores (num_colegiado)
    ) ENGINE = INNODB;

CREATE TABLE
    mensajes(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        id_paciente VARCHAR(10),
        id_medico VARCHAR(10),
        fecha DATE,
        mensaje VARCHAR(400),
        is_visto BOOLEAN,
        rol VARCHAR(20),
        FOREIGN KEY (id_paciente) REFERENCES pacientes (dni) ON DELETE CASCADE,
        FOREIGN KEY (id_medico) REFERENCES doctores (num_colegiado)
    ) ENGINE = INNODB;

CREATE TABLE
    antecedentes (
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        dni_paciente VARCHAR(10) NOT NULL,
        fecha DATE NOT NULL,
        diagnostico VARCHAR(20),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    ciclos_antibioticos(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        dni_paciente VARCHAR(10) NOT NULL,
        antibiotico VARCHAR(30),
        es_intravenoso BOOLEAN DEFAULT false,
        fecha_inicio DATE NOT NULL,
        fecha_fin DATE,
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    tratamientos_cronicos (
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        dni_paciente VARCHAR(10) NOT NULL,
        descripcion VARCHAR(60),
        fecha DATE NOT NULL,
        archivo VARCHAR(200),
        oral BOOLEAN,
        inhalado BOOLEAN,
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    datos_respiratorios(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        fvc DECIMAL(3, 2),
        fev1 DECIMAL(3, 2),
        saturacion_basal DECIMAL(4, 2),
        capacidad_aerobica DECIMAL(6, 3),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    eventos(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        descripcion VARCHAR(60),
        importancia INT(2),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    deportes(
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

CREATE TABLE
    analiticas(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        tipo VARCHAR(10),
        archivo VARCHAR(200),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    tension(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        max_tension INT(2),
        min_tension INT(2),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    glicadas(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        glicada DECIMAL(3, 2),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;

CREATE TABLE
    v02max(
        id Int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fecha DATE NOT NULL,
        dni_paciente VARCHAR(10) NOT NULL,
        v02max DECIMAL(5, 2),
        ppm_reposo INT(3),
        FOREIGN KEY (dni_paciente) REFERENCES pacientes (dni) ON UPDATE CASCADE ON DELETE CASCADE
    ) ENGINE = INNODB;