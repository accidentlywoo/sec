ALTER TABLE POSTAL
ADD CONSTRAINT buildingno_pk PRIMARY KEY(BUILDINGNO)
;
ALTER TABLE CUSTOMER
ADD buildingno VARCHAR2(25)
;
ALTER TABLE CUSTOMER
ADD CONSTRAINT customer_buildingno_fk FOREIGN KEY(buildingno) REFERENCES POSTAL(BUILDINGNO) 
;

select * from customer
;

ALTER TABLE CUSTOMER
ADD addr VARCHAR2(40)
;

commit;

SELECT * FROM CUSTOMER
;
delete customer
where id = 'id5'
;
ROLLBACK;
commit;

SELECT 
     c.id
    ,c.pwd
    ,c.name
    ,p.buildingno
    ,sido ||' '|| NVL(p.sigungu, ' ') || ' '|| NVL(p.eupmyun, ' ') city
    ,p.doro || ' ' || DECODE(building2, '0', building1, building1|| '-' ||building2) doro
    ,p.building
    ,c.addr
FROM customer c
LEFT OUTER JOIN postal p
    ON (c.buildingNo = p.buildingno)
WHERE 1=1
AND id = 'id1'
;

SELECT 
    prod_namem
    ,prod_no
    ,prod_price
FROM product
;