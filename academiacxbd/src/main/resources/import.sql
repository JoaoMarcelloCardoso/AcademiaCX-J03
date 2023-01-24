INSERT INTO tb_produto (sku, nome) VALUES ('ABC123', 'Martelo');
INSERT INTO tb_produto (sku, nome) VALUES ('ABC456', 'Alicate de corte');
INSERT INTO tb_produto (sku, nome) VALUES ('ABC789', 'Fita Isolante');
INSERT INTO tb_produto (sku, nome) VALUES ('DEF123', 'Multímetro Digital');
INSERT INTO tb_produto (sku, nome) VALUES ('DEF456', 'Chave Phillips');
INSERT INTO tb_produto (sku, nome) VALUES ('DEF789', 'Chave de Fenda');

INSERT INTO tb_cliente (cpf, nome) VALUES ('48788592621', 'João Silva');
INSERT INTO tb_cliente (cpf, nome) VALUES ('02772839654', 'Maria Vieira');
INSERT INTO tb_cliente (cpf, nome) VALUES ('32874869374', 'Carlos Roberto');
INSERT INTO tb_cliente (cpf, nome) VALUES ('25074277129', 'Ana Laura');

INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('01234567', 'Rua das Flores', '456', 'Jardim da Paz', 'Rio de Janeiro', 'RJ', 1);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('76543210', 'Avenida das Nações', '789', 'Parque das Américas', 'Belo Horizonte', 'MG', 4);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('55555555', 'Rua do Sol', '111', 'Bairro dos Sonhos', 'Salvador', 'BA', 1);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('99999999', 'Rua das Estrelas', '222', 'Vila das Estrelas', 'Porto Alegre', 'RS', 3);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('12345678', 'Rua dos Pássaros', '555', 'Bairro da Natureza', 'Curitiba', 'PR', 4);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('87654321', 'Avenida da Luz', '777', 'Parque dos Anjos', 'Fortaleza', 'CE', 2);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('09876543', 'Rua da Montanha', '888', 'Bairro dos Vales', 'Recife', 'PE', 2);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('56789012', 'Avenida do Mar', '999', 'Vila dos Oceanos', 'Florianópolis', 'SC', 3);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (27.80, 1, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (20.10, 2, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (10.50, 3, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (30.20, 4, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (18.50, 5, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (17.80, 6, 1);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (20.50, 1, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (18.10, 2, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (8.50, 3, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (27.20, 4, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (15.50, 5, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (12.80, 6, 2);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (27.80, 1, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (20.10, 2, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (10.50, 3, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (30.20, 4, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (18.50, 5, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (17.80, 6, 3);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (20.50, 1, 4);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (18.10, 2, 4);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (8.50, 3, 4);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (27.20, 4, 4);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (15.50, 5, 4);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (12.80, 6, 4);

INSERT INTO tb_carrinho (data_Hora, cliente_id ) VALUES(NOW(), 1);
INSERT INTO tb_carrinho (data_Hora, cliente_id) VALUES (NOW(), 2);

INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id ) VALUES(2, 6, 6, 1);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id ) VALUES(1, 5, 5, 1);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id ) VALUES(1, 2, 8, 2);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id ) VALUES(1, 3, 9, 2);



UPDATE tb_item SET total = (SELECT quantidade * valor FROM tb_preco WHERE tb_item.preco_id = tb_preco.id);

UPDATE tb_carrinho c SET c.total = (SELECT SUM(i.total) FROM tb_item i WHERE i.carrinho_id = c.id);