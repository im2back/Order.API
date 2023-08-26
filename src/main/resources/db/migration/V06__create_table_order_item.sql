CREATE TABLE IF NOT EXISTS public.tabela_order_item (
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES public.tabela_order (id),
    FOREIGN KEY (product_id) REFERENCES public.tabela_product (id)
);
