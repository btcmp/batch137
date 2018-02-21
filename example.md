# Oracle SQL
* Installation
* login with SQLplus 
* Activate User HR
* Data Selection
* Aritmatic Exp
* Where Clause

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
select * from employees where first_name = 'lex';
```

