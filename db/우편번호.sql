-- building 컬럼값에 '대학교'를 포함한 행들을 모두 출력하시오
SELECT * FROM postal
WHERE building like '%대학교%'
;
SELECT 
    zipcode
    ,buildingno
    ,sido city
    ,doro
    ,building
FROM postal
WHERE building LIKE '%홍익길%'
OR doro || ' ' || building || building2 LIKE '%홍익길%'
;