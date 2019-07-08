CREATE TABLE public."event"
(
    "id" uuid NOT NULL,
    component character varying NOT NULL,
    email character varying NOT NULL,
    environment character varying NOT NULL,
    "createdAt" timestamp with time zone NOT NULL,
    message character varying NOT NULL,
    data character varying,
    PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public."Event"
    OWNER to postgres;
    
    
CREATE INDEX idx_event_component ON public."event" ((lower(component)));
CREATE INDEX idx_event_createdAt ON public."event" ("createdAt");
CREATE INDEX idx_event_email ON public."event" (lower(email));
CREATE INDEX idx_event_environment ON public."event" (lower(environment));
CREATE INDEX idx_event_message ON public."event" USING GIN (to_tsvector('english', message));