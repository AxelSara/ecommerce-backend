SELECT * FROM zapateriapg.usuarios;
ALTER TABLE usuarios AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
ALTER TABLE usuarios MODIFY telefono VARCHAR(30);/* Modificamos tipo de dato para telefono*/
INSERT INTO usuarios (nombre, email, telefono, contraseña) VALUES 
("Mariana Calderon Martinez", "mariana1@gmail.com","5564972356","mariana123"),
("Rocio Gomez Noguez", "roxxGN@gmail.com","5569467031","Roxx102030"),
("Rodrigo Alcantar Lopez", "superlego@gmail.com","5578944569","rodri12345"),
("Lucia Bautista", "lucib@gmail.com","5563114930","lucia123456"),
("Alexis Hernandez", "hernandeza@gmail.com","5533462011","alex8963");