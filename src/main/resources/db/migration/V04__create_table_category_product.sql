CREATE TABLE IF NOT EXISTS public.tabela_product_category
(
    products_id bigint NOT NULL,
    categories_id bigint NOT NULL,
    PRIMARY KEY (products_id, categories_id),
    FOREIGN KEY (products_id)
        REFERENCES public.tabela_product (id),
    FOREIGN KEY (categories_id)
        REFERENCES public.tabela_category (id)
);
