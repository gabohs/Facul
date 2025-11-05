USE locadoracompleta;

SELECT * FROM cliente;

SELECT cli.nome, cli.telefone, cid.nome, cid.UF 
	FROM cliente as cli
	INNER JOIN cidade as cid
    ON cli.codcidade = cid.id;
    
    
SELECT cli.nome, cli.telefone, cid.nome, cid.UF 
	FROM cliente as cli
	INNER JOIN cidade as cid
    ON cli.codcidade = cid.id
    WHERE cid.UF = 'SP';
    
-- ===================================================================================

SELECT cli.nome, car.modelo, alu.dataDevolucao
	FROM aluguel as alu
    INNER JOIN cliente as cli
    ON cli.id = alu.codcliente
    INNER JOIN carro as car
    ON car.id = alu.codcarro;
    
SELECT cli.nome, car.modelo, alu.dataDevolucao
	FROM aluguel as alu
    INNER JOIN cliente as cli
    ON cli.id = alu.codcliente
    INNER JOIN carro as car
    ON car.id = alu.codcarro
	WHERE car.modelo = 'Civic';
    
-- ===================================================================================

SELECT carro.modelo, marca.nome, aluguel.valoraluguel
	FROM carro 
    INNER JOIN aluguel
    ON carro.id = aluguel.codcarro
    INNER JOIN marca
    ON carro.codmarca = marca.id
    ORDER BY aluguel.valoraluguel;
    
-- ===================================================================================
    
SELECT carro.modelo, marca.nome, SUM(aluguel.valoraluguel)
	FROM carro
    INNER JOIN marca
    ON marca.id = carro.codmarca
    INNER JOIN aluguel
    ON carro.id = aluguel.codcarro
    GROUP BY marca.nome
    ORDER BY SUM(aluguel.valoraluguel) DESC;

-- ===================================================================================

SELECT cliente.codcidade, cidade.nome, COUNT(aluguel.codcliente)
	FROM cliente
    INNER JOIN cidade
    ON cliente.codcidade = cidade.id
    INNER JOIN aluguel
    ON cliente.id = aluguel.codcliente
    GROUP BY cidade.id;