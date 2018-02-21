# Oracle SQL
* Installation
* login with SQLplus 
* Activate User HR
* Data Selection
* Aritmatic Exp
* Where Clause
* Comparation Operator
* Order by 
* Single Row Function
* Group Function


## Installation
## Login with SQLplus 
```sql
C:\Users\myremote>sqlplus / as sysdba;
```

## Activate User HR
```sql
SQL> alter user hr identified by 1234 account unlock;
User altered.
SQL> conn hr/1234
Connected.
SQL> show user;
USER is "HR"
SQL>
```

## Data Selection
### Selection All Field
## Aritmatic Exp
```sql
-- DUAL
select 'hello world' as kalimat from DUAL;
select 1 + 1 as penambahan from dual;
select 12 - 34 as penguarangan from dual;
select 10 + 5 * 2 as perkalian from dual;
```
### Null Value 
```sql
select 
  first_name, 
  last_name, 
  salary,
  commission_pct + 200
from employees;
```

## Where Clause
```sql
select * from employees where employee_id = 104;
select * from employees where upper(first_name) = upper('lex');
select upper('HeLLo WoRld') from dual;
select lower('Hello WorlD') from dual;
```

## Comparation Operator
```sql
select first_name, last_name, salary from employees 
where salary = 24000;
select first_name, last_name, salary from employees 
where salary >= 12000;
select first_name, last_name, salary from employees 
where salary <> 24000;
select first_name, last_name, salary from employees 
where salary != 24000;
```

### Is Null and Is Not Null
```sql
select first_name, last_name, salary, commission_pct from employees
where commission_pct is not null;
```

### Between
```sql
select first_name, last_name, salary from employees
where salary between 10000 and 15000;
select first_name, last_name, salary from employees
where salary > 10000 and salary < 15000;
```

### AND and OR
```sql
select first_name, last_name, salary from employees
where FIRST_NAME = 'Lex' and (SALARY = 17000 OR 1 = 0);
  
select first_name, last_name, salary from employees
where SALARY = 17000 OR (1=0 AND FIRST_NAME = 'Lex');
```

## Order by 
```sql
select * from employees
order by first_name asc;

select * from employees
order by first_name desc;

select first_name, last_name as nama_belakang from employees
order by nama_belakang desc;

select * from employees order by 4;
```

## Single Row Function
```sql
-- 1. Lower
select lower('agBDfdLls') from dual;

-- 2. Upper
Define first_name2 = 'Rifky'
Define last_name2 = 'nugraha'
select Upper('&first_name2' || ' ' || '&last_name2') from dual;
```

## Group Function
```sql
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
  having sum(salary) > Any(select salary from employees where first_name='David') 
order by jumlah;

-- Any => (OR)
select * from employees where first_name='David'
-- ALL => (AND)
```

Tugas :
buat pengelompakan data berdasarkan job_id, 
yang total gaji diatas gaji steven king
