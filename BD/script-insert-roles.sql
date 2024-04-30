SELECT * FROM zapateriapg.roles;
ALTER TABLE roles AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
INSERT INTO roles (nombreRol, descripcionRol) VALUES
("Cliente", "Este rol es exclusivo para compradores de la pagina, solo tendra algunos poderes otorgados"),
("Administrador", "Este rol es exclusivo para los usuarios que podran administar la oagina web, tendra otorgados todos los poderes"); 