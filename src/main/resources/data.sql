--        instrutor

INSERT INTO instrutor (NOME , NASCIMENTO, RG , TITULACAO ) VALUES ('Claudes', '1999-02-07', '99999999', 1);


INSERT INTO instrutor (nome, nascimento, rg, titulacao) VALUES ('David', '2000-05-19', '222222222', 2);

--    turma

INSERT INTO turma (horario, duracao, data_inicio, data_fim, instrutor_id) VALUES ('2023-05-07T18:25:25.930595200', 80, '2023-05-07', '2023-07-07', 1);

INSERT INTO turma (horario, duracao,  data_inicio, data_fim, instrutor_id) VALUES ('2023-05-07T18:25:25.930595200', 80, '2023-07-08', '2023-09-08', 2);