-- 권한 주기
GRANT select ON customer TO a;
GRANT select ON customer TO hr;

GRANT all ON customer To a;
-- all : SELECT, DELETE, UPDATE, INSERT

-- 권한 취소
REVOKE select ON customer FROM a;

REVOKE all ON customer FROM a;