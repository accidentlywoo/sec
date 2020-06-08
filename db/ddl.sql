SELECT * FROM user_tables;

-- 테이블 명 : ORDER_INFO
-- 컬럼들
-- 주문번호 NUMBER, : ORDER_NO
-- 주문자ID VARCHAR2(10) <- CUSTOMER ID : ORDER_ID
-- 주문일자 : VARCHAR2(10) : ORDER_DT
CREATE TABLE ORDER_INFO(
    ORDER_NO NUMBER
    ,ORDER_ID VARCHAR2(10)
    ,ORDER_DT VARCHAR2(10)
);

-- ALTER TABLE 기존 테이블의 구조 변경하기
-- 고객 테이블에 컬럼 추가하기
ALTER TABLE CUSTOMER
ADD zipcode CHAR(5);

-- 고객테이블의 컬럼의 타입이나 길이 변경하기
ALTER TABLE CUSTOMER
MODIFY pwd VARCHAR2(20);

-- 고객테이블의 컬럼명 변경하기
ALTER TABLE CUSTOMER
RENAME COLUMN zipcode TO zip;

-- 고객 테이블의 컬럼 제거하기
ALTER TABLE CUSTOMER
DROP COLUMN zip;

-- 기존 테이블의 제약조건 추가
ALTER TABLE CUSTOMER
ADD CONSTRAINT customer_id_pk PRIMARY KEY(id);

--ALTER TABLE customer
--ADD CONSTRAINT customer_pwd_nn NOT NULL(pwd);
-- NOT NULL 제약조건은 테이블 단위 제약조건을 줄 수 없고. 반드시 컬럼 단위로 제약조건을 줘야한다.

DELETE FROM CUSTOMER WHERE pwd IS NULL;

ALTER TABLE CUSTOMER
MODIFY pwd VARCHAR2(20)
CONSTRAINT customer_pwd_nn NOT NULL; -- pwd컬럼에 null 값이 들어있는 행이 있다.

-- 제약조건 제거하기
ALTER TABLE customer
DROP CONSTRAINT customer_pwd_nn;

SELECT * FROM user_constraints;

-- 테이블이 저장되어있는 데이터사전 : user_tables
-- 제약조건이 저장되어있는 데이터사전 : user_constraints
DESC user_constraints;

SELECT 
        owner
        , constraints_name, constraint_type
        , table_name
FROM user_constraints;

-- 고개테이블에
-- 이름컬럼(컬럼명 : name, 타입 : varchar2(20))을 추가하시오
ALTER TABLE CUSTOMER
ADD name VARCHAR(20);

-- 주문기본정보테이블에
-- 주문번호컬럼(컬럼명 : order_no)의 PRIMARY KEY제약조건을 추가하시오
ALTER TABLE ORDER_INFO
ADD CONSTRAINT order_no_pk PRIMARY KEY(order_no);

-- 주문기본정보테이블에
-- 주문자 ID컬럼(컬럼명 : order_id)에 NOT NULL 제약조건을 추가하시오
-- 주문자 ID컬럼은 고객테이블의 고객ID를 참조하도록 FOREIGN KEY제약조건을 추가하시오.
ALTER TABLE ORDER_INFO
MODIFY order_id VARCHAR2(10)
CONSTRAINT order_id_nn NOT NULL;

ALTER TABLE ORDER_INFO
MODIFY order_id NOT NULL;

---------------실습
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
-- SubQuery를 이용한 테이블 생성
SELECT * FROM CUSTOMER;

CREATE TABLE COPY_CUSTOMER
AS SELECT * FROM CUSTOMER;
-- 데이터 까지 복사됨.NOT NULL을 제외한 제약조건은 복사되지 않는다.

CREATE TABLE COPY_CUSTOMER1(cid, cpwd)
AS SELECT id,pwd FROM CUSTOMER; -- 컬럼을 선택적으로 복사해 오기

CREATE TABLE COPY_CUSTOMER2
AS SELECT * FROM CUSTOMER WHERE 1=0;



