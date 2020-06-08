SELECT * FROM user_tables;

-- ���̺� �� : ORDER_INFO
-- �÷���
-- �ֹ���ȣ NUMBER, : ORDER_NO
-- �ֹ���ID VARCHAR2(10) <- CUSTOMER ID : ORDER_ID
-- �ֹ����� : VARCHAR2(10) : ORDER_DT
CREATE TABLE ORDER_INFO(
    ORDER_NO NUMBER
    ,ORDER_ID VARCHAR2(10)
    ,ORDER_DT VARCHAR2(10)
);

-- ALTER TABLE ���� ���̺��� ���� �����ϱ�
-- �� ���̺� �÷� �߰��ϱ�
ALTER TABLE CUSTOMER
ADD zipcode CHAR(5);

-- �����̺��� �÷��� Ÿ���̳� ���� �����ϱ�
ALTER TABLE CUSTOMER
MODIFY pwd VARCHAR2(20);

-- �����̺��� �÷��� �����ϱ�
ALTER TABLE CUSTOMER
RENAME COLUMN zipcode TO zip;

-- �� ���̺��� �÷� �����ϱ�
ALTER TABLE CUSTOMER
DROP COLUMN zip;

-- ���� ���̺��� �������� �߰�
ALTER TABLE CUSTOMER
ADD CONSTRAINT customer_id_pk PRIMARY KEY(id);

--ALTER TABLE customer
--ADD CONSTRAINT customer_pwd_nn NOT NULL(pwd);
-- NOT NULL ���������� ���̺� ���� ���������� �� �� ����. �ݵ�� �÷� ������ ���������� ����Ѵ�.

DELETE FROM CUSTOMER WHERE pwd IS NULL;

ALTER TABLE CUSTOMER
MODIFY pwd VARCHAR2(20)
CONSTRAINT customer_pwd_nn NOT NULL; -- pwd�÷��� null ���� ����ִ� ���� �ִ�.

-- �������� �����ϱ�
ALTER TABLE customer
DROP CONSTRAINT customer_pwd_nn;

SELECT * FROM user_constraints;

-- ���̺��� ����Ǿ��ִ� �����ͻ��� : user_tables
-- ���������� ����Ǿ��ִ� �����ͻ��� : user_constraints
DESC user_constraints;

SELECT 
        owner
        , constraints_name, constraint_type
        , table_name
FROM user_constraints;

-- �����̺�
-- �̸��÷�(�÷��� : name, Ÿ�� : varchar2(20))�� �߰��Ͻÿ�
ALTER TABLE CUSTOMER
ADD name VARCHAR(20);

-- �ֹ��⺻�������̺�
-- �ֹ���ȣ�÷�(�÷��� : order_no)�� PRIMARY KEY���������� �߰��Ͻÿ�
ALTER TABLE ORDER_INFO
ADD CONSTRAINT order_no_pk PRIMARY KEY(order_no);

-- �ֹ��⺻�������̺�
-- �ֹ��� ID�÷�(�÷��� : order_id)�� NOT NULL ���������� �߰��Ͻÿ�
-- �ֹ��� ID�÷��� �����̺��� ��ID�� �����ϵ��� FOREIGN KEY���������� �߰��Ͻÿ�.
ALTER TABLE ORDER_INFO
MODIFY order_id VARCHAR2(10)
CONSTRAINT order_id_nn NOT NULL;

ALTER TABLE ORDER_INFO
MODIFY order_id NOT NULL;

---------------�ǽ�
CREATE TABLE ORDER_LINE(
    ORDER_NO NUMBER,
    ORDER_PROD_NO NUMBER,
    ORDER_QUANTITY NUMBER
);
ALTER TABLE ORDER_LINE
MODIFY ORDER_PROD_NO CHAR(5);

ALTER TABLE ORDER_LINE
ADD CONSTRAINT order_line_no_fk FOREIGN KEY(ORDER_NO) REFERENCES ORDER_INFO(ORDER_NO);

ALTER TABLE ORDER_LINE
ADD CONSTRAINT prod_no_fk FOREIGN KEY(ORDER_PROD_NO) REFERENCES PRODUCT(PROD_NO);

ALTER TABLE ORDER_LINE
DROP CONSTRAINT prod_no_fk;

ALTER TABLE ORDER_LINE
ADD CONSTRAINT order_no_fk PRIMARY KEY(ORDER_NO, ORDER_PROD_NO);

ALTER TABLE ORDER_LINE
MODIFY ORDER_QUANTITY NOT NULL
ADD CONSTRAINT order_line_quantity_check CHECK(ORDER_QUANTITY >=0);

CREATE TABLE PRODUCT(
    PROD_NO NUMBER(5),
    PROD_NAME VARCHAR2(30),
    PROD_PRICE NUMBER(7)
);

ALTER TABLE PRODUCT
ADD CONSTRAINT prod_no_pk PRIMARY KEY(PROD_NO);

ALTER TABLE PRODUCT
ADD CONSTRAINT prod_price_check CHECK(PROD_PRICE >=0);

ALTER TABLE PRODUCT
DROP CONSTRAINT prod_no_pk;

ALTER TABLE PRODUCT
MODIFY PROD_NO CHAR(5);
-----------------------
-- SubQuery�� �̿��� ���̺� ����
SELECT * FROM CUSTOMER;

CREATE TABLE COPY_CUSTOMER
AS SELECT * FROM CUSTOMER;
-- ������ ���� �����.NOT NULL�� ������ ���������� ������� �ʴ´�.

CREATE TABLE COPY_CUSTOMER1(cid, cpwd)
AS SELECT id,pwd FROM CUSTOMER; -- �÷��� ���������� ������ ����

CREATE TABLE COPY_CUSTOMER2
AS SELECT * FROM CUSTOMER WHERE 1=0;



