-- liquibase formatted sql

-- changeset cloverix:2026-08-07--0001-users
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) NOT NULL
);

-- changeset cloverix:2026-08-07--0002-wallets
CREATE TABLE wallets (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    name VARCHAR(32) NOT NULL,
    default_currency VARCHAR(3) NOT NULL
);

-- changeset cloverix:2026-08-07--0003-goals
CREATE TABLE goals (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    name VARCHAR(32) NOT NULL,
    description VARCHAR(128),
    status VARCHAR(16) NOT NULL DEFAULT 'active' CHECK (status IN ('active', 'achieved')),
    default_currency VARCHAR(3) NOT NULL,
    target_amount DECIMAL(12, 2) NOT NULL,
    send_reminders BOOLEAN NOT NULL,
    single_amount DECIMAL(12, 2),
    reminder_days INTEGER,
    reminder_time TIME,
    last_notif_sent_at TIMESTAMP DEFAULT NULL
);

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

-- changeset cloverix:2026-08-07--0005-add-indexes
CREATE INDEX idx_wallets_user_id ON wallets(user_id);
CREATE INDEX idx_goals_user_id ON goals(user_id);
CREATE INDEX idx_transactions_wallet_id ON transactions(wallet_id);
CREATE INDEX idx_transactions_goal_id ON transactions(goal_id);
CREATE INDEX idx_users_email ON users(email);