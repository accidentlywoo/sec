-- building �÷����� '���б�'�� ������ ����� ��� ����Ͻÿ�
SELECT * FROM postal
WHERE building like '%���б�%'
;
SELECT 
    zipcode
    ,buildingno
    ,sido city
    ,doro
    ,building
FROM postal
WHERE building LIKE '%ȫ�ͱ�%'
OR doro || ' ' || building || building2 LIKE '%ȫ�ͱ�%'
;