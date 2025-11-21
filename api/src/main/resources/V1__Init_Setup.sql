CREATE TABLE plans
(
    id                  bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name                varchar     NOT NULL,
    description         varchar,
    time                timestamptz NOT NULL,
    location            varchar     NOT NULL
);