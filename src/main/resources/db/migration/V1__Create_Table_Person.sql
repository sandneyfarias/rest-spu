-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
    id serial NOT NULL,
    address character varying(100) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(6) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;
