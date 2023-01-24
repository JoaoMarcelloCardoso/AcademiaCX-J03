INSERT INTO tb_cliente (id,cpf, nome) VALUES (1,'12345678901', 'João Silva');
INSERT INTO tb_cliente (id,cpf, nome) VALUES (2,'23456789012', 'Maria Costa');
INSERT INTO tb_cliente (id,cpf, nome) VALUES (3,'34567890123', 'José Ferreira');

INSERT INTO tb_produto (id,sku, nome,quantidade_total) VALUES (1,'SKU0001','Placa de vídeo',20);
INSERT INTO tb_produto (id,sku, nome,quantidade_total) VALUES (2,'SKU0002','SSD',10);
INSERT INTO tb_produto (id,sku, nome,quantidade_total) VALUES (3,'SKU0003','Processador',15);


INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (1,'12345678','Rua dos Bobos','Bairro dos Bobos','Curitiba','1999', 33, 1);

INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (2,'11111111','Rua dos Pássaros','Bairro dos Pássaros','Curitiba','999', 55, 1);
INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (3,'33333333','Rua dos Animais','Bairro dos Animais','Cidade dos Animais','2999', 99, 2);

INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (4,'55555555','Avenida das Montanhas','Bairro das Montanhas','Cidade das Montanhas','520', 77, 2);


INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (5,'56789098','Rua das Flores','Bairro das Flores','Cidade das Flores','1234', 66, 3);

INSERT INTO tb_endereco (id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
VALUES
    (6,'76543213','Rua dos Animais','Bairro dos Animais','Cidade dos Animais','4321', 55, 3);


INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (1,1000.75, 1,1);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (2,234.00, 2,1);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (3,150.41, 3,1);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (4,333.12, 1,2);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (5,123.00, 2,2);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (6,322.23, 3,2);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (7,323.00, 1,3);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (8,232.88, 2,3);
INSERT INTO tb_preco (id,valor,produto_id,cliente_id) VALUES (9,131.87, 3,3);


INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (1,'2023-01-01 01:00:01',0.00,1);
INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (2,'2023-01-01 23:59:59',0.00,1);
INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (3,'2022-12-25 01:01:11',0.00,2);
INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (4,'2022-12-25 24:00:00',0.00,2);
INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (5,'2022-12-31 01:01:01',0.00,3);
INSERT INTO tb_carrinho (id,hora_compra,total,cliente_id) VALUES (6,'2023-12-31 23:59:59',0.00,3);


INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (1,4,1,1,1);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (2,4,3,3,1);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (3,2,5,1,2);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (4,5,6,2,2);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (5,6,7,1,3);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (6,4,8,2,3);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (7,7,7,1,4);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (8,3,8,2,4);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (9,3,7,1,5);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (10,2,8,2,5);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (11,7,7,1,6);
INSERT INTO tb_item (id,quantidade,preco_id,produto_id,carrinho_id) values (12,12,8,2,6);