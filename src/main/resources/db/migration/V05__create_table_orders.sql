CREATE TABLE IF NOT EXISTS public.tabela_order (
    id SERIAL PRIMARY KEY,
    moment TIMESTAMP WITH TIME ZONE NOT NULL,
    order_status VARCHAR(255) NOT NULL,
    client_id BIGINT REFERENCES public.tabela_user(id)
);
