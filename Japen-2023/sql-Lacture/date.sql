-- 날짜 관련 함수들
SELECT SYSDATE AS NOW, 
SYSDATE-1 AS YESTERDAY,
SYSDATE+1 AS YESTERDAY
FROM DUAL;

-- ADD_MONTHS
SELECT SYSDATE AS NOW,
ADD_MONTHS(SYSDATE,3) AS 삼개월뒤
FROM DUAL;

SELECT EMPNO,ENAME,HIREDATE,ADD_MONTHS(HIREDATE, 120) AS WORK10YEAR
FROM EMP;

--MONTHS_BETWEEN
SELECT EMPNO,ENAME,HIREDATE,SYSDATE,
MONTHS_BETWEEN(SYSDATE,HIREDATE) AS MONTH01,
ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE))AS MONTH02,
TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) AS MONTH03
FROM EMP;

--NEXT_DAY(),LAST_DAY()
SELECT SYSDATE, NEXT_DAY(SYSDATE,'일요일'),
LAST_DAY(SYSDATE)
FROM DUAL;

--형변환 함수 TO_CHAR(),TO_NUMBER(),TO_DATE
SELECT TO_NUMBER('12345') FROM DUAL;

SELECT EMPNO,ENAME,EMPNO + 500 FROM EMP;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS') FROM DUAL;

SELECT SYSDATE, 
TO_CHAR(SYSDATE,'MM') AS MM ,
TO_CHAR(SYSDATE,'MON') AS MON,
TO_CHAR(SYSDATE,'MONTH') AS MONTH,
TO_CHAR(SYSDATE,'DD') AS DD, --날짜를 숫자로 포맷
TO_CHAR(SYSDATE,'DY') AS DY, --날짜를 숫자로 포맷
TO_CHAR(SYSDATE,'DAY') AS DAY --날짜를 숫자로 포맷
FROM EMP;

SELECT SYSDATE, 
TO_CHAR(SYSDATE,'MM') AS MM ,
TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE = KOREN') AS MON, --KOR
TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE = ENGLISH') AS MON, --ENG
TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE = JAPANESE') AS MON, --JP
TO_CHAR(SYSDATE,'DD') AS DD, --날짜를 숫자로 포맷
TO_CHAR(SYSDATE,'DY') AS DY, --날짜를 숫자로 포맷
TO_CHAR(SYSDATE,'DAY') AS DAY --날짜를 숫자로 
FROM DUAL;


SELECT SAL,
TO_CHAR(SAL, '$999,999') AS SAL_$,
TO_CHAR(SAL, 'L999,999') AS SAL_L,
TO_CHAR(SAL, '999,999.00') AS SAL_01,
TO_CHAR(SAL, '000,999,999.00') AS SAL_01
FROM EMP;

SELECT 1300 - '1500',
'1300' + '1500'
FROM DUAL;

SELECT TO_NUMBER('1,300','999,999') - TO_NUMBER('1,500','999,999') FROM DUAL;

--날짜로 바꾸기

SELECT * FROM EMP
WHERE HIREDATE > TO_DATE('1981/06/01','YYYY/MM/DD');

--NULL는 연산 안됨 IS NULL IS NULL NVL(COMM,0);
SELECT EMPNO,ENAME,SAL,COMM,
SAL+COMM, NVL(COMM,0),
SAL * 12+NVL(COMM,0) AS ANNSAL
FROM EMP;

SELECT EMPNO,ENAME,SAL,COMM,
SAL+NVL(COMM,0),
NVL2(COMM, SAL*12+COMM,SAL*12) AS ANNSAL 
FROM EMP;

-- DECODE IF ELSE
-- 보너스 차등 지급 MANAGER 10, SALESMAN 5, ANALYST 0,3% 

SELECT EMPNO, ENAME, JOB ,SAL,
DECODE(JOB,
'MANAGER', SAL * 1.1,
'SALSMAN', SAL * 1.05,
'ANALYST', SAL, SAL * 1.03
) AS BONUS 
FROM EMP;


SELECT EMPNO, ENAME, JOB ,SAL,
DECODE(JOB,
'MANAGER','관리자',
'PRESIDENT','최고 관리자',
'ANALYST', '분석가',
'CLERK','사원',
'영업사원'
) AS BONUS 
FROM EMP;

SELECT EMPNO, ENAME, JOB, SAL,
CASE
WHEN JOB = 'MANAGER' THEN SAL*1.1
WHEN JOB = 'SALESMAN' THEN SAL*1.05
WHEN JOB = 'ANALYST' THEN SAL
ELSE SAL*1.03
END AS BONUS
FROM EMP;

SELECT EMPNO, ENAME, COMM,
CASE
WHEN COMM IS NULL THEN '해당사항없음'
WHEN COMM = 0 THEN '보너스'
WHEN COMM > 0 THEN  '보너스' || COMM
END AS BONUS
FROM EMP;

SELECT EMPNO, ENAME, COMM,
CASE
WHEN COMM >= 2900 THEN 'DIAMOND'
WHEN COMM >= 2700 THEN 'GOLD'
WHEN COMM >= 2000 THEN  'SILVER'
ELSE 'BRONZE'
END AS BONUS
FROM EMP;

SELECT EMPNO, ENAME,
CASE
WHEN TO_CHAR(HIREDATE,'Q') = '1' THEN '1 분기 입사'
WHEN TO_CHAR(HIREDATE,'Q') = '2' THEN '2 분기 입사'
WHEN TO_CHAR(HIREDATE,'Q') = '3' THEN '3 분기 입사'
WHEN TO_CHAR(HIREDATE,'Q') = '4' THEN '4 분기 입사'
ELSE '해당사항없음'
END AS 분기별_입사
FROM EMP;

-- 연습문제 1 ~ 4번
SELECT EMPNO, RPAD(SUBSTR(EMPNO,1,2),4,'*') AS MASKING_EMPNO,
EMPNO, RPAD(SUBSTR(EMPNO,1,1),4,LENGTH(ENAME),'*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME)>=5 AND LENGTH(ENAME) < 6;

SELECT EMPNO, ENAME, SAL, 
TRUNC(SAL/21.5) AS DAY_PAY,
ROUND(SAL/21.5/8) AS TIME_PAY
FROM EMP;

SELECT EMPNO, ENAME, HIREDATE,
TO_CHAR(ADD_MONTHS(HIREDATE,3),'YYYY-MM-DD') AS R_JOB,
NVL(TO_CHAR(COMM), 'N/A') AS COMM
FROM EMP;

SELECT EMPNO, ENAME, MGR,
CASE
WHEN MGR IS NULL THEN '0000'
WHEN SUBSTR((TO_CHAR(MGA)), 1,2) = '75' THEN '5555'
WHEN SUBSTR((TO_CHAR(MGA)), 1,2) = '76' THEN '6666'
WHEN SUBSTR((TO_CHAR(MGA)), 1,2) = '77' THEN '7777'
WHEN SUBSTR(MGA, 1,2) = '78' THEN '8888'
ELSE TO_CHAR(MGA)
END AS CHG_MGR
FROM EMP;