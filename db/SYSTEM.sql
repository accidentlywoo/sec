-- ���� �����ϱ�
CREATE USER a IDENTIFIED BY 1;

select * from user_tables;

-- A ������ �̿��ؼ� DB ���� �� ���̺�/�ε���/������ ��ü ��������
-- ���� ���
GRANT connect, resource TO a;
-- resource �������� privilage�� �����ִ� role -> resource

-- �ó�� �������� ���
GRANT create synonym, create public synonym TO a;
