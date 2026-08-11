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

-- changeset cloverix:2026-08-11--0006-insert-data
INSERT INTO users (email, password) VALUES
    ('efremenko160107@mail.ru', 'clover'),
    ('randomusr@mail.ru', 'pass');

INSERT INTO wallets (user_id, name, default_currency) VALUES
    (1, 'general', 'RUB'),
    (2, 'All Expences', 'RUB');

INSERT INTO goals (user_id, name, description, status, default_currency, target_amount, send_reminders, single_amount, reminder_days, reminder_time, last_notif_sent_at) VALUES
    (1, 'My goal', 'My dream', 'active', 'RUB', 1000000, TRUE, 500, 1, '18:00:00', NULL);

INSERT INTO transactions (wallet_id, goal_id, type, category, amount, currency, description, created_at, updated_at) VALUES
    (1, 1, 'income', 'goal', 250, 'RUB', 'first transaction', '2026-08-07T19:13:00', NULL),
    (2, NULL, 'expense', 'food', 5000, 'RUB', NULL, '2026-08-01T12:37:46', NULL);