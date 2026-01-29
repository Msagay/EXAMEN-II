-- Script de Creación de la Base de Datos smExoTrooper
-- Prefijos 'sm' aplicados a Tablas y Columnas

CREATE TABLE IF NOT EXISTS smUsuario (
    smIdUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    smNombre TEXT NOT NULL,
    smUsername TEXT NOT NULL UNIQUE,
    smPassword TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS smTipoArma (
    smIdTipoArma INTEGER PRIMARY KEY AUTOINCREMENT,
    smNombre TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS smArma (
    smIdArma INTEGER PRIMARY KEY AUTOINCREMENT,
    smIdTipoArma INTEGER NOT NULL,
    smNombre TEXT NOT NULL,
    FOREIGN KEY (smIdTipoArma) REFERENCES smTipoArma(smIdTipoArma)
);

CREATE TABLE IF NOT EXISTS smTipoExobot (
    smIdTipoExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    smNombre TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS smExobot (
    smIdExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    smIdTipoExobot INTEGER NOT NULL,
    smIdUsuario INTEGER,
    smEntrenado INTEGER DEFAULT 0, -- 0: No, 1: Si
    smNumeroAccion INTEGER DEFAULT 0,
    smIdArma INTEGER,
    FOREIGN KEY (smIdTipoExobot) REFERENCES smTipoExobot(smIdTipoExobot),
    FOREIGN KEY (smIdUsuario) REFERENCES smUsuario(smIdUsuario),
    FOREIGN KEY (smIdArma) REFERENCES smArma(smIdArma)
);

CREATE TABLE IF NOT EXISTS smExoTracer (
    smIdExoTracer INTEGER PRIMARY KEY AUTOINCREMENT,
    smIdExobot INTEGER,
    smNumeroAccion INTEGER,
    smEnShow TEXT,
    FOREIGN KEY (smIdExobot) REFERENCES smExobot(smIdExobot)
);

-- Datos Iniciales (Seed Data)
INSERT INTO smUsuario (smNombre, smUsername, smPassword) VALUES 
('Patricio Michael', 'patmic', '123'),
('Micaela Dannae', 'mica', '321');

INSERT INTO smTipoArma (smNombre) VALUES ('Fusil / Revolver');
INSERT INTO smTipoArma (smNombre) VALUES ('GPS / Giroscopio');
INSERT INTO smTipoArma (smNombre) VALUES ('Misil / Mortero');
INSERT INTO smTipoArma (smNombre) VALUES ('BioSensor / BioEscaner');
INSERT INTO smTipoArma (smNombre) VALUES ('Laser / Bayoneta');

INSERT INTO smTipoExobot (smNombre) VALUES ('ExoAsalto');
INSERT INTO smTipoExobot (smNombre) VALUES ('ExoExplorador');
INSERT INTO smTipoExobot (smNombre) VALUES ('ExoInfanteria');
INSERT INTO smTipoExobot (smNombre) VALUES ('ExoMedico');
INSERT INTO smTipoExobot (smNombre) VALUES ('ExoComando');

-- Mapeo inicial de Armas (Simplificado para el ejemplo)
-- Se asume orden secuencial 1-5 corresponde a los tipos
INSERT INTO smArma (smIdTipoArma, smNombre) VALUES (1, 'Fusil');
INSERT INTO smArma (smIdTipoArma, smNombre) VALUES (2, 'GPS');
INSERT INTO smArma (smIdTipoArma, smNombre) VALUES (3, 'Misil');
INSERT INTO smArma (smIdTipoArma, smNombre) VALUES (4, 'BioSensor');
INSERT INTO smArma (smIdTipoArma, smNombre) VALUES (5, 'Laser');