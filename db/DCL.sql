-- ���� �ֱ�
GRANT select ON customer TO a;
GRANT select ON customer TO hr;

GRANT all ON customer To a;
-- all : SELECT, DELETE, UPDATE, INSERT

-- ���� ���
REVOKE select ON customer FROM a;

REVOKE all ON customer FROM a;