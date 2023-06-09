-- 다중행 함수

--합계
SELECT SUM(SAL) AS TOTAL FROM EMP;

--평균
SELECT TRUNC(AVG(SAL))AS AVG FROM EMP;

--최대
SELECT MAX(SAL) AS MAX FROM EMP;

--최소
SELECT MIN(SAL) AS MIN FROM EMP;

--갯수
SELECT COUNT(*) AS COUNT FROM EMP;

SELECT SUM(SAL) AS TOTAL,
MAX(SAL) AS MAX,
MIN(SAL) AS MIN,
TRUNC(AVG(SAL)) AS AVG,
COUNT(*) AS COUNT
FROM EMP;

SELECT SUM(SAL) AS SAL_TOTAL,
       SUM(ALL SAL) AS SAL_ALL,
       SUM(DISTINCT SAL) AS SAL_DISTINCT
FROM EMP;

-- 부서 번호가 20번인 사람중에 제일 오래된 사람
SELECT MIN(HIREDATE) FROM EMP
WHERE DEPTNO = 20;

--평균 급여 10, 20, 30
SELECT TRUNC(AVG(SAL)),'10' AS DEPTNO FROM EMP WHERE DEPTNO = 10
UNION ALL
SELECT TRUNC(AVG(SAL)),'20' AS DEPTNO FROM EMP WHERE DEPTNO = 20
UNION ALL
SELECT TRUNC(AVG(SAL)),'30' AS DEPTNO FROM EMP WHERE DEPTNO = 30;

SELECT TRUNC(AVG(SAL)) AS SAL_AVG, DEPTNO 
FROM EMP
GROUP BY DEPTNO;

SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP
WHERE SAL <= 3000
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;
--1.WHERE-> 2.GROUP BY-> 3.HAVING-> 4.ORDER BY
SELECT * FROM EMP;

--연습문제 1~4번

SELECT DEPTNO, 
TRUNC(AVG(SAL)) AS AVG_SAL,
TRUNC(AVG(SAL)) AS MAX_SAL,
TRUNC(AVG(SAL)) AS MIN_SAL,
COUNT(*) AS COUNT 
FROM EMP
GROUP BY DEPTNO;

SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
HAVING COUNT(*) >= 3;

SELECT TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR, DEPTNO,
COUNT(*) AS COUNT
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY'), DEPTNO;

SELECT NVL2(COMM, 'O','X') AS EXIST_COMM,
COUNT(*) AS COUNT
FROM EMP
GROUP BY NVL2(COMM,'O','X');

--JOIN




















