-- 트리거 테스트
-- 주문기본정보(order_info)이 추가되면 자동 POINT(point)가 1점 누적된다.
INSERT INTO order_info(order_no, order_id, order_dt)
VALUES (ORDER_SEQ.nextval, 'id1', SYSDATE);

SELECT * FROM order_info;
SELECT * FROM point;

-- 주문 트랜잭션
-- 1) 주문기본정보 추가
----  2) 포인트점수 누적 : 자동
-- 3) 주문상세정보 추가
INSERT INTO order_line(order_no, order_prod_no, order_quantity)
VALUES(ORDER_SEQ.CURRVAL, 'C0001', 1);

commit;

select * FROM order_line;