-- �Լ�
-- �Լ��� ��ȯ���� �ݵ�� �ִ�.
-- ��ȯ���� ���Ե� ������ var�Ǵ� variable�� �����Ѵ�.
-- ������ �����Ҷ��� :������ :=�Լ�;
-- ������ ����Ҷ��� print ��ɾ ����Ѵ�.
-- �߾Ⱦ�.
VARIABLE msg VARCHAR2;
EXECUTE :msg := f1;
print msg;

SELECT f1 FROM dual;

SELECT id ||' ' || f1 FROM customer;