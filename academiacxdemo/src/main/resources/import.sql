INSERT INTO tb_cliente(id, cpf, nome) VALUES (1, '01234567890', 'José');
INSERT INTO tb_cliente(id, cpf, nome) VALUES (2, '05647895321', 'Maria');
INSERT INTO tb_cliente(id, cpf, nome) VALUES (3, '11547893245', 'João');

INSERT INTO tb_produto(id, sku, nome) VALUES (123, '2354fgv23', 'Pendrive');
INSERT INTO tb_produto(id, sku, nome) VALUES (456, '11885abgr', 'Placa-mãe');
INSERT INTO tb_produto(id, sku, nome) VALUES (789, '773qwx3vb', 'Mouse');

INSERT INTO tb_preco(id, valor, produto_id, cliente_id) VALUES (1, 100.00, 123, 1);
INSERT INTO tb_preco(id, valor, produto_id, cliente_id) VALUES (2, 200.00, 789, 2);
INSERT INTO tb_preco(id, valor, produto_id, cliente_id) VALUES (3, 50.00, 121, 3);

INSERT INTO tb_endereco(id, cep, logradouro, bairro, cidade, uf, cliente_id) VALUES (1, '80300900', 'Rua da hamburguer', 'Jardim Botânico', 'Curitiba', 'PR', 1);
INSERT INTO tb_endereco(id, cep, logradouro, bairro, cidade, uf, cliente_id) VALUES (2, '80300910', 'Rua da pizza', 'Centro', 'Curitiba', 'PR', 1);
INSERT INTO tb_endereco(id, cep, logradouro, bairro, cidade, uf, cliente_id) VALUES (3, '81300123', 'Rua do pão de queijo', 'Juveve', 'Curitiba', 'PR', 2);


INSERT INTO tb_carrinho(id, datahora, total, cliente_id) VALUES (1, '2023/01/02', 10, 1);
INSERT INTO tb_carrinho(id, datahora, total, cliente_id) VALUES (2, '2022/12/24', 20, 2);
INSERT INTO tb_carrinho(id, datahora, total, cliente_id) VALUES (3, '2022/09/12', 10, 3);

INSERT INTO tb_item(id, quantidade, total, produto_id, preco_id, carrinho_id) VALUES (1, 10, 50.00, 123, 1, 1);
INSERT INTO tb_item(id, quantidade, total, produto_id, preco_id, carrinho_id) VALUES (2, 100, 30.00, 456, 2, 2);
INSERT INTO tb_item(id, quantidade, total, produto_id, preco_id, carrinho_id) VALUES (3, 40, 20.00, 789, 3, 3);