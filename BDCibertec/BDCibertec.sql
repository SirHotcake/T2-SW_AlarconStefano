CREATE DATABASE BDCibertec;

CREATE TABLE Autor
(
 IdAutor 		INT NOT NULL AUTO_INCREMENT,
 NomAutor		VARCHAR(50) NOT NULL,
 ApeAutor 		VARCHAR(50) NOT NULL,
 FechNacAutor	DATE NOT NULL,
 PRIMARY KEY (IdAutor)
);

CREATE TABLE Publicacion
(
 IdPublicacion 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Resumen 			VARCHAR(250) NOT NULL,
 FechPublicacion	DATE NOT NULL,
 IdAutor 			INT NOT NULL,
 PRIMARY KEY (IdPublicacion),
 FOREIGN KEY (IdAutor) REFERENCES Autor(IdAutor)
 );
 


INSERT INTO Autor (NomAutor, ApeAutor, FechNacAutor) VALUES
('Gabriel', 'García Márquez', '1927-03-06'),
('Isabel', 'Allende', '1942-08-02'),
('Mario', 'Vargas Llosa', '1936-03-28'),
('Julio', 'Cortázar', '1914-08-26'),
('Jorge Luis', 'Borges', '1899-08-24');


INSERT INTO Publicacion (Titulo, Resumen, FechPublicacion, IdAutor) VALUES
('Cien Años de Soledad', 'Una novela sobre la familia Buendía en Macondo', '1967-05-30', 1),
('La Casa de los Espíritus', 'Relato de la familia Trueba en Chile', '1982-10-15', 2),
('La Ciudad y los Perros', 'Una novela sobre cadetes en una escuela militar', '1963-01-01', 3),
('Rayuela', 'Una novela innovadora y experimental', '1963-06-28', 4),
('El Aleph', 'Una colección de cuentos', '1949-01-01', 5);
