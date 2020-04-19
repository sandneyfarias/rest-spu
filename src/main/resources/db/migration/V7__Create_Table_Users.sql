﻿CREATE TABLE IF NOT EXISTS users (
  id serial NOT NULL,
  user_name varchar(255) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  account_non_expired bit(1) DEFAULT NULL,
  account_non_locked bit(1) DEFAULT NULL,
  credentials_non_expired bit(1) DEFAULT NULL,
  enabled bit(1) DEFAULT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  UNIQUE (user_name)
);

ALTER TABLE public.users
    OWNER to postgres;
