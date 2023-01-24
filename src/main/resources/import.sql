INSERT INTO produto 
	(id, sku, nome) 
VALUES 	
	(1, 'P001', 'Arroz'),	
	(2, 'P002', 'Feijão'),
	(3, 'P003', 'Café'),
	(4, 'E001', 'Xbox One'),	
	(5, 'E002', 'Playstation 5'),
	(6, 'E003', 'Nintendo Wii');

INSERT INTO cliente 
	(id, cpf, nome) 
VALUES 
	(1, '12345611111', 'Chico Buarque'),
	(2, '22233344452', 'Ivone Lara'),
	(3, '33399935343', 'Ozzy Osbourne');

INSERT INTO carrinho 
	(id, datahora, total, cliente_id) 
VALUES 
	(1, '2022-01-10 15:01:00', 100, 1),
	(2, '2022-01-10 16:44:00', 200, 2),
	(3, '2022-01-11 17:33:00', 150, 3),
	(4, '2022-01-20 11:41:00', 120, 1),
	(5, '2022-01-22 12:14:00', 90, 2),
	(6, '2022-01-31 17:51:00', 50, 3);


INSERT INTO endereco 
	(id, cep, logradouro, numero, bairro, cidade, uf, cliente_id)
VALUES 
	(1, '82940150', 'Rua das Orquideas', 'n 11', 'Jardim Limoeiro', 'Gotham City', 'MG', 1),
	(2, '40500200', 'Rua Principal', 'n 42', 'Vila Cafezinho', 'São Paulo', 'SP', 2),
	(3, '33333000', 'Rua de Cima', 'n 60', 'Parque Industrial', 'Brodowski', 'SP', 3),
	(4, '11120190', 'Avenida dos Eucaliptos', 'n 500', 'Centro', 'Gotham City', 'MG', 1),
	(5, '23422123', 'Avenida da Industria', 'n 99', 'Parque Industrial', 'Brodowski', 'SP', 3),
	(6, '67867844', 'Rua das Orquideas', 'n 360', 'Centro', 'Pontal do Parana', 'PR', 2);

INSERT INTO preco 
	(id, valor, produto_id, cliente_id) 
VALUES
 	(1, 50, 2, 3),
	(2, 25, 3, 2),
	(3, 30, 1, 1),
	(4, 50, 2, 2),
	(5, 25, 3, 1),
	(6, 30, 1, 3),
	(7, 50, 2, 1),
	(8, 25, 3, 3),
	(9, 30, 1, 2);

INSERT INTO item 
	(id, quantidade, total, produto_id, preco_id, carrinho_id) 
VALUES 
	(1, 100, 10, 1, 1, 3),
	(2, 90, 40, 2, 3, 2),
	(3, 120, 90, 3, 2, 1),
	(4, 10, 100, 1, 4, 3),
	(5, 50, 500, 2, 5, 2),
	(6, 30, 300, 3, 6, 1);

