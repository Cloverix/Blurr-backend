-- liquibase formatted sql

-- changeset cloverix:2026-08-07--0005-add-indexes
CREATE INDEX idx_wallets_user_id ON wallets(user_id);
CREATE INDEX idx_goals_user_id ON goals(user_id);
CREATE INDEX idx_transactions_wallet_id ON transactions(wallet_id);
CREATE INDEX idx_transactions_goal_id ON transactions(goal_id);