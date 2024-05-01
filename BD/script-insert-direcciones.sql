SELECT * FROM zapateriapg.direcciones;
ALTER TABLE productos AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
INSERT INTO direcciones (calle, colonia, email, cp, delegacionMunicipio,estado,indicacionesEspeciales,noExterior,noInterior,nombreDomicilio,nombreUsuario,telefono,usuarios_idUsuario) 
VALUES 
("poniente 10", "Girasol", "mariana1@gmail.com", "56613", "Gustavo Amadero","Ciudad de mexico",'Sin indicaciones',"14","3","oficina","Mateo Garcia","1234567890","4"),
("San juanita", "rio verde","roxxGN@gmail.com", "55983","Venustiano Carranza","Edo.Mex",'Entrega en casa habitacion de dos pisos color naranja',"127","22","casita","Armando Torres","1234659803","5"),
("Aves no43", "San miguel","superlego@gmail.com", "56497", "Valle de chalco","Mexico",'Sin indicaciones',"3","36","Casa Rodrigo","Pamela Ozorio","1236975640","1"),
("tepeyac", "San isidro", "lucib@gmail.com", "13649", "chalco","mexico",'entregar solo al titular',"45","2","casa 2","Guadalupe Bautista","1647895230","2"),
("Axayacatl", "lopez mateos", "hernandeza@gmail.com", "58673", "tlahuac","Edo.Mex",'Entregar frente al edificio',"56","13","Edificio Carolina","Carolina Mendoza","1345697524","2");