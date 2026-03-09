# Correcao dos exercicios

> [!IMPORTANT]
> Essas sao as minhas solucoes, para ver as do prof. consultar o material dele no drive (arquivo com o mesmo nome na pasta Exer - PL-SQL)

## 3.A

```sql
set serverout on 

DECLARE
    v_maior emp.empno%type;
    v_ename emp.ename%type
    v_job   emp.job%type

BEGIN
    select max(empno)
    into v_maior
    from emp;

    select ename, job
    into v_ename, v_job
    from emp
    where empno = v_maior;

    DBMS_OUTPUT.NEW_LINE;
    dbms_output.put_line('Nome: ' || to_char(v_ename) || '  Cargo: ' || to_char(v_job) || ' Num: ' || to_char(v_maior));

END;
```