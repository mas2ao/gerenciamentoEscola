CREATE DATABASE IF NOT EXISTS gerenciamentoEscola;
USE gerenciamentoEscola;

CREATE TABLE IF NOT EXISTS Professor(
	id int not null auto_increment,
	nome varchar(255),
	email varchar(255),
	telefone varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Turma(
	id int not null auto_increment,
	codigo int,
	turma varchar(255),
	descricao varchar(255),
	vagas int,
	PRIMARY KEY (id)
);
