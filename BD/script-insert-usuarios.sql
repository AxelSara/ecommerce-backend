SELECT * FROM zapateriapg.usuarios;
ALTER TABLE usuarios AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
INSERT INTO usuarios (nombre, email, telefono, contraseña, roles_idRol) VALUES 
("Mariana Calderon Martinez", "mariana1@gmail.com","5564972356","mariana123","1"),
("Rocio Gomez Noguez", "roxxGN@gmail.com","5569467031","Roxx102030","1"),
("Rodrigo Alcantar Lopez", "superlego@gmail.com","5578944569","rodri12345","2"),
("Lucia Bautista", "lucib@gmail.com","5563114930","lucia123456", "1"),
("Alexis Hernandez", "hernandeza@gmail.com","5533462011","alex8963", "2");