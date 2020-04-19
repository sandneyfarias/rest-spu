INSERT INTO public.person VALUES (1, 'Maceió - Alagoas - Brasil', 'Sandney', 'Male', 'Farias');
INSERT INTO public.person VALUES (2, 'Maceió - Alagoas - Brasil', 'Maria Helena', 'Female', 'Farias');

SELECT pg_catalog.setval('public.person_id_seq', 3, true);
