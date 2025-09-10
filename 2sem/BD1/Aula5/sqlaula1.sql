USE X;

CREATE TABLE alunos (
	nome VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    aniversario DATE,
    profissao VARCHAR(50),
    lugar VARCHAR(50)
);

DESC alunos;

INSERT INTO alunos VALUES ('Gabriel', 'schaeffer.gabrielh@gmail.com', '21/03/2007', 'Estudante', 'IFRS'), 
						  ('Emanuel', 'emanuel@gmail.com', '11/12/2006', 'Estudante', 'IFRS');

SELECT * FROM alunos
