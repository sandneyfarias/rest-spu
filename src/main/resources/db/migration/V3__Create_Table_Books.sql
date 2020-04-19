CREATE TABLE public.book (
  id serial NOT NULL,
  author text,
  launch_date TIMESTAMP NOT NULL,
  price decimal(65,2) NOT NULL,
  title text,
  CONSTRAINT book_pkey PRIMARY KEY (id)
);

ALTER TABLE public.book
    OWNER to postgres;

