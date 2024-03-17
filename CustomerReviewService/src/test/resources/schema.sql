DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE IF NOT EXISTS customer
(
    id bigint NOT NULL,
    email character varying(50) ,
    name character varying(100) ,
    status character varying(30) ,
    surname character varying(100) ,
    latitude double precision,
    longitude double precision,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    );

CREATE SEQUENCE IF NOT EXISTS customer_id_seq start with 1 increment by 50;

DROP TABLE IF EXISTS customer_review;

CREATE TABLE IF NOT EXISTS customer_review
(
    id bigint NOT NULL,
    customer_id bigint,
    restaurant_id bigint,
    score character varying(10),
    comment character varying(500),
    CONSTRAINT customer_review_pkey PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
    );

CREATE SEQUENCE IF NOT EXISTS customer_review_id_seq start with 1 increment by 50;