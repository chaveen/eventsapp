CREATE TABLE IF NOT EXISTS public."event"
(
    "id" uuid NOT NULL,
    component character varying NOT NULL,
    email character varying NOT NULL,
    environment character varying NOT NULL,
    created_at timestamp with time zone NOT NULL,
    message character varying NOT NULL,
    data character varying,
    PRIMARY KEY ("id")
)
WITH (
    OIDS = FALSE
);
    
    
CREATE INDEX IF NOT EXISTS idx_event_component ON public."event" ((lower(component)));
CREATE INDEX IF NOT EXISTS idx_event_created_at ON public."event" ("created_at");
CREATE INDEX IF NOT EXISTS idx_event_email ON public."event" (lower(email));
CREATE INDEX IF NOT EXISTS idx_event_environment ON public."event" (lower(environment));
CREATE INDEX IF NOT EXISTS idx_event_message ON public."event" USING GIN (to_tsvector('english', message));