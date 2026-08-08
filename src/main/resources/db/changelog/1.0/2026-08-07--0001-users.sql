-- liquibase formatted sql

-- changeset cloverix:2026-08-07--0001-users
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) NOT NULL
);