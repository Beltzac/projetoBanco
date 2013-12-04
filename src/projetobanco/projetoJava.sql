USE test;

CREATE TABLE cliente(
codigo int(4) auto_increment,
nome varchar(45),
sobreNome varchar(45),
rg varchar(45),
cpf varchar(45),
endereco varchar(45),
salario double,
CONSTRAINT pkCliente PRIMARY KEY (codigo));

CREATE TABLE contaCorrente(
numero int(4) auto_increment,
cliente int(4),
saldo double,
depositoInicial double,
limite double,
CONSTRAINT pkContaCorrente PRIMARY KEY (numero),
CONSTRAINT fkContaCorrenteCliente FOREIGN KEY (cliente) REFERENCES cliente(codigo));



CREATE TABLE contaInvestimento(
numero int(4) auto_increment,
cliente int(4),
saldo double,
depositoInicial double,
montanteMinimo double,
depositoMinimo double,
CONSTRAINT pkContaInvestimento PRIMARY KEY (numero),
CONSTRAINT fkContaInvestimentoCliente FOREIGN KEY (cliente) REFERENCES cliente(codigo));
