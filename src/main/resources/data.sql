-- ==============================
-- 초기 User 데이터 삽입
-- ==============================
-- admin 계정 비밀번호: admin123
-- user1 계정 비밀번호: user123
INSERT INTO users (username, password, email, role, active, created_at, updated_at)
VALUES
('admin', '$2b$12$mbA3ijlGdixs//ZYK2d2muXGW0UxnxNmuEGpndUzOBg2mMjnWQ3Dq', 'admin@example.com', 'ADMIN', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user1', '$2b$12$IBVR/rBfkl.tVYIt1V18EuOhqLma6JCnCttXRMQc7GKdwpzaSvT3u', 'user1@example.com', 'USER', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);