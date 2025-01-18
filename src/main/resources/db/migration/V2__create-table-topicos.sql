CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    mensagem VARCHAR(250) NOT NULL,
    data_criacao DATETIME NOT NULL,
    estado_topico VARCHAR(15) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso VARCHAR(25) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
