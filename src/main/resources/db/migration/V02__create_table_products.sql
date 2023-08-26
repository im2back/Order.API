CREATE TABLE IF NOT EXISTS tabela_product (
    id SERIAL primary key,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price double PRECISION,
    img_Url VARCHAR(255) 
   
    
);