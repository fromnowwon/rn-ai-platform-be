-- ==============================
-- 초기 User 데이터 삽입
-- ==============================
INSERT INTO users (username, password, email, role, active, created_at, updated_at)
VALUES
('admin', 'admin123', 'admin@example.com', 'ADMIN', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user1', 'user123', 'user1@example.com', 'USER', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);