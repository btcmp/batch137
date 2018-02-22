# CONTOH Intro SQL (Oracle)

```sql
-- selection all field
select * from employees;
-- selection field and alias
select 
  employee_id as id,
  first_name as nama_depan,
  last_name as nama_belakang,
  email
from employees;

-- aritmatic expression
-- DUAL
select 'hello world' as kalimat from DUAL;
select 1 + 1 as penambahan from dual;
select 12 - 34 as penguarangan from dual;
select (10 + 5) * 2 as perkalian from dual;

-- add bonus field
select 
  first_name, 
  last_name, 
  email, 
  salary,
  salary * 2-100 as bonus
from employees;

-- null field
select 
  first_name, 
  last_name, 
  salary,
  commission_pct + 200
from employees;

-- Clause WHERE 
select * from employees where employee_id = 104;
select * from employees where upper(first_name) = upper('lex');
select upper('HeLLo WoRld') from dual;
select lower('Hello WorlD') from dual;

-- Comparation Operator
select first_name, last_name, salary from employees 
where salary = 24000;
select first_name, last_name, salary from employees 
where salary >= 12000;
select first_name, last_name, salary from employees 
where salary <> 24000;
select first_name, last_name, salary from employees 
where salary != 24000;

-- is null and is not null
select first_name, last_name, salary, commission_pct from employees
where commission_pct is not null;

-- Between
select first_name, last_name, salary from employees
where salary between 10000 and 15000;
select first_name, last_name, salary from employees
where salary > 10000 and salary < 15000;

-- AND and OR
select first_name, last_name, salary from employees
where FIRST_NAME = 'Lex' and (SALARY = 17000 OR 1 = 0);
  
select first_name, last_name, salary from employees
where SALARY = 17000 OR (1=0 AND FIRST_NAME = 'Lex');

-- Order by 
-- untuk mengurutkan berdasarkan field tertentu
select * from employees
order by first_name asc;

select * from employees
order by first_name desc;

select first_name, last_name as nama_belakang from employees
order by nama_belakang desc;
select * from employees order by 4;

-- Ampersand
set verify on
DEFINE theId = 106
select * from employees where employee_id = &theId;

-- Single Row Function
-- 1. Lower
select lower('agBDfdLls') from dual;

-- 2. Upper
Define first_name2 = 'Rifky'
Define last_name2 = 'nugraha'
select Upper('&first_name2' || ' ' || '&last_name2') from dual;

-- 3. InitCap
Define word1 = 'inDoneSia'
Define word2 = 'jaYa'
select initcap('&word1' || ' ' || '&word2') from dual;
select 
  initcap(last_name || ' ' || email) as fullname,
  salary
from employees where employee_id = 100;

-- concat
-- untuk menyambung String
define word1 = 'hello'
define word2 = 'world'
select concat('&word1', ' &word2') from dual;
select 'hello' || 'world' || 'apik' from dual;

-- trim
define word1 = '   hello         sdldl fsl     '
select '&word1' from dual;
select trim('&word1') from dual;

-- round
select round(7.54567, 2) from dual;
select trunc(7.54167, 2) from dual;
select mod(98, 100) from dual;

-- date
select sysdate from dual;
select first_name, hire_date from employees where hire_date = to_date('JUN-17-03', 'MM-DD-YY');

desc employees;

-- Group Function
-- 1. AVG (Rata Rata)
select trunc(avg(salary), 2) from employees;
-- 2. SUM (Penjulahan)
select sum(salary) from employees;
-- 3. Max
select max(salary) from employees;
select * from employees where salary = 24000;
-- 4. min
select min(salary) from employees;
-- 5. count (menghitung jumlah record)
-- field base
select count(commission_pct) from employees;
-- all
-- 6. STDDEV and variance
select stddev(salary) from employees;
select variance(salary) from employees;

-- Group by 
select * from employees;
select 
  avg(salary) as rata2, 
  sum(salary) as total,
  count(*) as jumlah,
  job_id
from employees 
  -- where job_id <> 'AC_MGR'
  group by job_id 
  having sum(salary) > ALL(select * from employees where first_name='David') 
order by jumlah;

-- Any => (OR)
select * from employees where first_name='David'
-- ALL => (AND)

-- Multiple Table
-- INNER JOIN select 
 select  
  employee_id,
  first_name,
  last_name,
  emp.department_id,
  dept.department_id,
  dept.department_name,
  salary,
  loc.street_address as "alamat kantor"
from employees emp
inner join departments dept
on emp.department_id = dept.department_id
inner join locations loc
on loc.location_id = dept.location_id


select * from employees; --107
select * from departments; -- 27
select * from departments where department_id = 60;

--- Left OUTER JOIN
select 
  emp.first_name,
  emp.last_name,
  dept.department_name,
  loc.STREET_ADDRESS
from employees emp
left outer join departments dept
on emp.department_id = dept.department_id
left outer join locations loc
on dept.location_id = loc.location_id

-- Right Outer Join
select 
   emp.first_name nama_depan,
  emp.last_name as nama_belakang,
  dept.department_name as "nama department",
  emp.department_id,
  dept.department_id
from employees emp
right outer join departments dept
on emp.department_id = dept.department_id
-- DDL
-- Create table 
-- Constraint
  -- Relation
  
-- soal 2
select round(avg(salary), 2) as rata2, dept.department_name 
from employees emp
inner join departments dept
on emp.department_id = dept.department_id
group by dept.department_name
having sum(emp.salary) > (select sum(emp.salary)
from employees emp
inner join departments dept
on emp.department_id = dept.department_id
where dept.department_name = 'Marketing'
)
order by rata2

select 
  emp.first_name,
  emp.email,
  mng.first_name
from employees emp
left outer join employees mng
on emp.manager_id = mng.employee_id;
select * from employees;

-- DDL (Data Definition Language)
-- create & constraint
drop table department_137;
CREATE TABLE department_137(
  id int,
  name_department varchar2(144),
  email varchar2(144),
  constraint cons_dpet_pk primary key(id),
  constraint cons_email_un unique(email)
);

drop table employees_137;
create table employees_137(
  id int,
  name varchar2(144),
  address varchar2(144) not null,
  email varchar2(144),
  department_id int,
  constraint cons_emp_pk primary key(id),
  constraint cons_email_emp unique(email),
  constraint cons_reff_dept foreign key(department_id)
  references department_137(id)
);

desc department_137;
desc employees_137;
-- constraint
-- primary key
-- unique
-- not null
-- foreign key

-- DML
insert into department_137(id, name_department, email) values (3, 'infrastruktur3', 'infra3@xsis.co.id'); 
insert into department_137(id, name_department, email) values (4, 'infrastruktur3', 'infra4@xsis.co.id');
insert into department_137(id, name_department, email) values (5, 'infrastruktur3', 'infra5@xsis.co.id');
insert into department_137(id, name_department, email) values (6, 'infrastruktur3', 'infra6@xsis.co.id');
select * from department_137;
select * from employees_137;

insert into employees_137
(id, name, address, email, department_id)
values
(1, 'andita', 'jakarta selatan', 'andita@gmail.com', 5);

insert into employees_137
(id, name, address, email, department_id)
values
(2, 'andita', 'jakarta selatan', 'andita2@gmail.com', 3);

-- delete department_137
select * from department_137;
select * from employees_137;
delete from employees_137 where id = 2;
delete from department_137 where id = 3;

-- drop table 
drop table department_137;
drop table employees_137;

-- searching 
-- 1. equals "="
select * from employees where 
first_name = 'William' and last_name='Smith'
;
-- 2. in 
select * from employees where 
first_name = 'William' or first_name = 'Lex'

select * from employees where
first_name in('Will', 'Lex', 'Steven')

-- 3. like
-- huruf paling depan L
select * from employees where
first_name like 'L%'
-- yang diakhiri huruf l
select * from employees where
first_name like '%l'
-- yang mengandung huruf "sa"
select * from employees where 
first_name like '%sa%'
desc locations;

-- UNION
select street_address as t1, postal_code as t2 from locations
union
select first_name, last_name from employees
order by 2

select first_name, last_name from employees
union all 
select first_name, last_name from employees

select first_name, last_name from employees
intersect 
select first_name, last_name from employees

select first_name, last_name from employees
minus 
select first_name, last_name from employees
```