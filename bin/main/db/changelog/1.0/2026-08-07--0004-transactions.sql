-- liquibase formatted sql

-- changeset cloverix:2026-08-07--0004-transactions
CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    wallet_id BIGINT NOT NULL REFERENCES wallets(id),
    goal_id BIGINT REFERENCES goals(id),
    type VARCHAR(16) NOT NULL CHECK(type IN('income', 'expense')),
    category VARCHAR(64) NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    description VARCHAR(128),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL
);