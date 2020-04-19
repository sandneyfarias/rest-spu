CREATE TABLE IF NOT EXISTS permission (
  id serial NOT NULL,
  description varchar(255) DEFAULT NULL,
  CONSTRAINT permission_pkey PRIMARY KEY (id)
);

ALTER TABLE public.permission
    OWNER to postgres;
