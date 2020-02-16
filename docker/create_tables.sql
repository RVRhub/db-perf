REATE TABLE public.entries (
    id serial NOT NULL,
    title TEXT,
    body TEXT,
    CONSTRAINT pk PRIMARY KEY (id)
);

INSERT INTO public.entries VALUES
    (100, 'Test_User', 'Main Text');