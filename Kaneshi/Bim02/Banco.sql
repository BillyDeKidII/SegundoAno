CREATE TABLE Vendedores (
codigo_vendedor number(3) PRIMARY KEY,
nome_vendedor varchar2(40)
);

CREATE TABLE Venda (
numero_venda number(5) PRIMARY KEY,
data_venda date,
codigo_vendedor number(3),
FOREIGN KEY(codigo_vendedor) REFERENCES Vendedores (codigo_vendedor)
);

CREATE TABLE Produtos (
codigo_produto number(5) PRIMARY KEY,
descricao_produto varchar2(50),
valor_produto number(8,2),
tamanho_produto varchar2(1),
quantidade_produto number(7,2)
);

CREATE TABLE Item_Venda (
numero_venda number(5),
item number(3),
codigo_produto number(5),
quantidade_item_de_venda number(7,2),
PRIMARY KEY(numero_venda,item),
FOREIGN KEY(numero_venda) REFERENCES Venda (numero_venda),
FOREIGN KEY(codigo_produto) REFERENCES Produtos (codigo_produto)
);

