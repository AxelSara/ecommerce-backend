SELECT * FROM zapateriapg.pedidos;
ALTER TABLE usuarios AUTO_INCREMENT = 1; /* INICIALIZAMOS EL CONTADOR EN 1*/
INSERT INTO pedidos (email, fechaPedido, monto, usuarios_idUsuario,direcciones_idDirecciones) VALUES
("mariana1@gmail.com", '2024-04-25 15:30:00',"860", "2","1"),
("lucib@gmail.com", '2024-04-25 15:30:00',"420", "3","4"),
("roxxGN@gmail.com", '2024-04-25 15:30:00',"1260", "5","5"),
("hernandeza@gmail.com", '2024-04-25 15:30:00',"420", "4","2"),
("superlego@gmail.com", '2024-04-25 15:30:00',"1680", "1","3");