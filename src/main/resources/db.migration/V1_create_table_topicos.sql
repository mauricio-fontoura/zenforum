CREATE TABLE zendb.teste (
	id bigint NOT NULL auto_increment,
	titulo varchar(100) NOT NULL,
	mensagem varchar(100) NOT NULL,
	datacriacao DATE NOT NULL,
	estadotopico varchar(100) NOT NULL,
	curso varchar(100) NOT NULL,
	CONSTRAINT topicos_pk PRIMARY KEY (id),
	CONSTRAINT topicos_unique UNIQUE KEY (titulo),
	CONSTRAINT topicos_unique_1 UNIQUE KEY (mensagem)
	
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_nopad_ci;