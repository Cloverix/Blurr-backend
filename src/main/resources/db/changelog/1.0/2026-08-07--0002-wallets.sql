-- liquibase formatted sql

-- changeset cloverix:2026-08-07--0002-wallets
CREATE TABLE wallets (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    name VARCHAR(32) NOT NULL,
    default_currency VARCHAR(3) NOT NULL
);