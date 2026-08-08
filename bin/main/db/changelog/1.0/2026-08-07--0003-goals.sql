-- liquibase formatted sql

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