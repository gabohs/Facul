USE locadoracompleta;

-- ==========================================================================

SELECT * FROM cidade
	WHERE nome LIKE "%e%";
    
SELECT * FROM cidade
	WHERE uf IN ('RS', 'PR');
    
SELECT nome FROM cidade
	WHERE regiao NOT LIKE 'Sul';
    
-- ==========================================================================

SELECT * FROM marca 
	WHERE nome like 'Honda';
    
SELECT * FROM marca
	WHERE nome NOT IN ('Fiat', 'Nissan', 'Hyundai');
    
-- ==========================================================================

SELECT * FROM cliente
	WHERE cpf LIKE 89974126398;
    
SELECT * FROM cliente
	WHERE bairro LIKE 'Centro' AND data_nascimento < '2000-01-01';
    
SELECT * FROM cliente
	WHERE data_nascimento BETWEEN '1998-12-26' AND '2001-02-20';
    
-- ==========================================================================

SELECT modelo FROM carro
	WHERE placa LIKE "%9";
    
SELECT * FROM carro
	WHERE cor = 'Preto';
    
SELECT * FROM carro
	WHERE (ANO BETWEEN 2022 AND 2026) AND (ANO NOT LIKE 2024);
    
-- ==========================================================================

SELECT * FROM aluguel 
	WHERE codcliente LIKE 3 OR codcliente like 4;
    
SELECT * FROM aluguel
	WHERE codcliente IN (1, 2, 5, 6);
    
SELECT * FROM aluguel 
	WHERE codcarro LIKE 1;
    
-- ==========================================================================
	