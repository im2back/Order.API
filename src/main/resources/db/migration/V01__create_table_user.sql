CREATE TABLE IF NOT EXISTS tabela_user (
    id SERIAL primary key,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
    
);