SELECT * FROM zapateriapg.pedidos;
ALTER TABLE usuarios AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
INSERT INTO pedidos (email, fechaPedido, usuarios_id_usuario, carritos_id_carrito,direcciones_id_direcciones) VALUES
("mariana1@gmail.com", '2024-04-25 15:30:00', "2", "3","6"),
("lucib@gmail.com", '2024-04-25 15:30:00', "3", "1","7"),
("roxxGN@gmail.com", '2024-04-25 15:30:00', "5", "4","8"),
("hernandeza@gmail.com", '2024-04-25 15:30:00', "4", "5","9"),
("superlego@gmail.com", '2024-04-25 15:30:00', "1", "2","10");