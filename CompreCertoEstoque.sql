DROP DATABASE CompreCertoEstoque;
CREATE DATABASE CompreCertoEstoque;
USE CompreCertoEstoque;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Funcionario (
    Id_func INT(50) PRIMARY KEY AUTO_INCREMENT,
    Email VARCHAR(50) NOT NULL,
    Nome_func VARCHAR(40) NOT NULL,
    Senha VARCHAR(20) NOT NULL,
    Cargo INT NOT NULL,
    CPF VARCHAR(15) NOT NULL,
    Telefone VARCHAR(20),
    UNIQUE(Email,CPF)
);


CREATE TABLE Produto (
    Id_produto int(50) PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(55) NOT NULL UNIQUE,
    Cod_produto VARCHAR(100) 
);
select * from Produto;

CREATE TABLE Operacao(
	Id_operacao INT(50) PRIMARY KEY AUTO_INCREMENT,
	Tipo_operacao  CHAR(1) NOT NULL,
    Data_operacao DATE,
    Id_func_fk INT(50),
    FOREIGN KEY (Id_func_fk) REFERENCES Funcionario(Id_func) on delete cascade,
    CONSTRAINT Tipo_operacao CHECK (sexo in ('E', 'S'))
);

Create  table Item_Operacao(
	Id_item_operacao INT(50) PRIMARY KEY AUTO_INCREMENT,
    Id_operacao_fk INT(50),
    Id_produto_fk INT(50),
    Quantidade_produto INT(50) NOT NULL,
    FOREIGN KEY (Id_produto_fk) REFERENCES Produto(Id_produto) ON DELETE RESTRICT,
    FOREIGN KEY (Id_operacao_fk) REFERENCES Operacao(Id_operacao) ON DELETE cascade
);


CREATE TABLE Estoque(
	Id_estoque INT PRIMARY KEY AUTO_INCREMENT,
	Id_produto_fk Int,
    Nome_produto varchar(55),
    Quantidade_minima INT,
    Quantidade_produto INT,
    FOREIGN KEY (Id_produto_fk) REFERENCES Produto(Id_produto)
);
INSERT INTO Estoque( Nome_produto, Quantidade_minima, Quantidade_produto) values('Teste',5,10);

INSERT INTO Funcionario (Email,Nome_func,Senha,Cargo,CPF,Telefone)
VALUES	('marcoantoniozxcv@gmail.com','Marco Antonio','123456',1,'922.778.280-09','+55(34)99697-6165'),
		('gwanderson98@gmail.com','Wanderson','123456',2,'530.658.360-17','+55(34)99898-2316'),
        ('marcoantonio@gmail.com','Marco','123456',2,'473.745.630-60','+55(34)98765-4123'),
        ('gwanderson@gmail.com','Anderson','123456',1,'501.689.070-62','+55(41)12345-6789');
        
SELECT Id_func,Telefone,CPF,Senha, Nome_func, Email, Cargo FROM Funcionario where Email ='marcoantonio@gmail.com' and Senha='123456';

select * from Funcionario;
SELECT * FROM Funcionario where CPF='" + (String) CPF + "';
INSERT INTO Produto(Nome,Cod_produto)
VALUES	('Vitamina C','12345678654'),
		('Vitamina D','321654789963'),
		('Vitamina E','987654312123'),
        ('Omega 3', '963852741123');

INSERT INTO Estoque(Id_produto_fk, Nome_produto, Quantidade_minima, Quantidade_produto) 
values (1,"Anador",5,10),
	   (2,"Doril",6,12),
       (3,"Dorflex",7,14),
       (4,"Benegripe",8,16);
select Id_estoque, Nome_produto, Quantidade_minima, Quantidade_produto from Estoque;
        
INSERT INTO Operacao(Tipo_operacao,Data_operacao,Id_func_fk)
VALUES	('E','2019-06-14',1),
		('E','2019-05-20',1),
        ('E','2019-03-20',2),
        ('S','2019-07-12',2),
        ('S','2019-08-10',3),
        ('S','2019-11-12',4);

INSERT INTO Item_Operacao(Id_operacao_fk,Id_produto_fk,Quantidade_produto)
VALUES	(1,1,10),
		(1,2,20),
        (2,1,15),
        (2,4,5),
        (3,3,3),
        (4,1,10),
        (5,2,10),
        (6,3,1);
        
INSERT INTO usuarios
values(1,'teste','123','teste');

select * from Funcionario;



