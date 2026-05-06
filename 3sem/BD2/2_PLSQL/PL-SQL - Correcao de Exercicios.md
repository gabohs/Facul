# Correcao dos exercicios

> [!IMPORTANT]
> Essas sao as minhas solucoes, para ver as do prof. consultar o material dele no drive (arquivo com o mesmo nome na pasta Exer - PL-SQL)

<details>

<summary>3.A</summary>

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

</details>


<details>

<summary>3.B</summary>

```sql
DECLARE
	v_maxhiredate emp.hiredate%type;

	v_dptnum emp.empno%type;
	v_dptname dept.dname%type;
	v_dptloc dept.loc%type;

BEGIN
	select max(hiredate)
	into v_maxhiredate
	from emp;

	select deptno
	into v_dptnum
	from emp
	where hiredate = v_maxhiredate;

	select dname, loc
	into v_dptname, v_dptloc
	from dept
	where deptno = v_dptnum;

	dbms_output.put_line( 'DPTNUM: ' || to_char(v_dptnum) || '   DPTNAME: ' || to_char(v_dptname) || '   DPTLOC: ' || to_char(v_dptloc) );
	DBMS_OUTPUT.NEW_LINE;
	dbms_output.put_line('DIA: ' || to_char(v_maxhiredate) );

END;
/
```

#### OU

```sql
DECLARE
	v_dname  dept.dname%type;
	v_loc dept.loc%type

BEGIN
	select dname, loc
	into v_dname, v_loc
	from dept
	where detpno = (select deptno
			from emp
			where hiredate = (select max(hiredate) from emp));


END;
```

</details>


<summary>3.C</summary>

```sql
DECLARE
	v_nome    emp.ename%type;
	v_cargo   emp.job%type;
	v_salario emp.sal%type;
	v_loc     dept.loc%type;


BEGIN
	select ename, job, sal
	into v_nome, v_cargo, v_salario
	from emp
	where sal between 4000 and 6000;

	select loc 
	into v_loc
	from dept
	where deptno = (select deptno 
			from emp
			where sal = v_salario); 

	dbms_output.put_line( 'NAME: ' || to_char(v_nome) || '   CARGO: ' || to_char(v_cargo) || '   SALARIO: ' || to_char(v_salario) );
	DBMS_OUTPUT.NEW_LINE;
	dbms_output.put_line('LOCALIZACAO: ' || to_char(v_loc) );

END;
/
```

#### OU

```sql
DECLARE
	v_nome    emp.ename%type;
	v_cargo   emp.job%type;
	v_salario emp.sal%type;

	v_deptno  dept.deptno%type;
	v_loc     dept.loc%type;


BEGIN
	select ename, job, sal, deptno
	into v_nome, v_cargo, v_salario, v_deptno
	from emp
	where sal between 4000 and 6000;

	select loc
	into v_loc
	from dept
	where deptno = v_deptno;
	
			
	dbms_output.put_line( 'NAME: ' || to_char(v_nome) || '   CARGO: ' || to_char(v_cargo) || '   SALARIO: ' || to_char(v_salario) );
	DBMS_OUTPUT.NEW_LINE;
	dbms_output.put_line('LOCALIZACAO: ' || to_char(v_loc) );

END;
/
```

#### OU

```sql
DECLARE
	v_nome    emp.ename%type;
	v_cargo   emp.job%type;
	v_salario emp.sal%type;

	v_deptno  dept.deptno%type;
	v_loc     dept.loc%type;


BEGIN
	select e.ename, e.job, e.sal, e.deptno, d.loc
	into v_nome, v_cargo, v_salario, v_deptno, v_loc
	from emp e, dept d
	where 
		e.deptno = d.deptno and
		e.sal between 4000 and 6000;

			
	dbms_output.put_line( 'NAME: ' || to_char(v_nome) || '   CARGO: ' || to_char(v_cargo) || '   SALARIO: ' || to_char(v_salario) );
	DBMS_OUTPUT.NEW_LINE;
	dbms_output.put_line('LOCALIZACAO: ' || to_char(v_loc) );

END;
/
```

</details>

<details>

<summary>4.A</summary>

```sql
CREATE OR REPLACE PROCEDURE info_funcionario(v_fnum emp.empno%type) as
	v_name     emp.ename%type;
	v_hiredate emp.hiredate%type;
	v_loc      dept.loc%type;

BEGIN
	select e.ename, e.hiredate, d.loc
	into v_name, v_hiredate, v_loc
	from emp e, dept d
	where
		e.deptno = d.deptno AND 
		e.empno = v_fnum;

	dbms_output.put_line( 'Nome: ' || to_char(v_name) || ' - Contratacao: ' || to_char(v_hiredate) || ' - Loc: ' || to_char(v_loc) );

END;
/
```

</details>

<details>

<summary>4.B</summary>

```sql
CREATE OR REPLACE PROCEDURE p_menor_sal_cidade( p_ncidade dept.loc%type ) as
	v_deptno  dept.deptno%type;
	v_fnome   emp.ename%type;
	v_salario emp.sal%type;

BEGIN
	select deptno 
	into v_deptno
	from dept
	where loc = p_ncidade;

	select MIN(sal)
	into v_salario
	from emp
	where deptno = v_deptno;

	select ename
	into v_fnome
	from emp
	where sal = v_salario;

	dbms_output.put_line( 'Nome: ' || to_char(v_fnome) || ' - Salario: ' || to_char(v_salario) );

END;
/
```

</details>

<details>

<summary>5.A</summary>

```sql
CREATE OR REPLACE FUNCTION f_media_sal_mgr( p_gerente emp.mgr%type ) RETURN NUMBER as
	v_media_sal emp.sal%type;
BEGIN
	select avg(sal)
	into v_media_sal
	from emp
	where mgr = p_gerente;

	RETURN v_media_sal;

END;
/
```

> para testar: select f_media_sal_mgr(7698) from dual;

</details>

<details>

<summary>11</summary>

```sql
BEGIN
	update dept
	set loc = 'DALLAS'
	where dname = 'IT';

	dbms_output.put_line('Foram Atualizadas ' || to_char(SQL%ROWCOUNT) || ' linhas');

END;
/
```

</details>

<details>

<summary>12</summary>

```sql
DECLARE
	v_num dept.deptno%type;

BEGIN
	select deptno 
	into v_num
	from dept
	where dname = 'RESEARCH';

	-- ou v_num := v_num + 1 

	insert into dept (deptno, dname, loc)
	values (v_num + 1, 'PROJETO', 'ERECHIM');	

	dbms_output.put_line('Novo dept inserido: ' || to_char(v_num + 1));

	commit;

END;
/
```

#### OU

```sql
-- alter table dept modify (deptno NUMBER(3));

BEGIN
	insert into dept (deptno, dname, loc)
	values (SEQ_DEPT.NEXTVAL, 'ENROLACAO', 'GAURAMA');	

	commit;

END;
/
```

</details>

<details>

<summary>13</summary>


1. Criar a tabela auxiliar EMP_INS

```sql
create table EMP_INS
(
	EMPNO number(4), 
	DNAME varchar2(514), 
	DATA  date, 
	SAL   number(7,2)
); 
```

2. Fazer a Trigger

```sql
CREATE OR REPLACE TRIGGER t_registra_empregado
after insert on emp
for each row
DECLARE
	v_dname dept.dname%type;

BEGIN
	select dname
	into v_dname
	from dept
	where deptno = :new.deptno;

	insert into emp_ins (EMPNO, DNAME, DATA, SAL)
	values (:new.empno, v_dname, sysdate, :new.sal);

END;
/
```

```sql
insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, LEAVEDATE, SAL, COMM, DEPTNO)
	values      (7935, 'PEDRO', 'MANAGER', 7839, sysdate, null, 3550, null, 10);
```

</details>

<summary>14</summary>

```sql
CREATE OR REPLACE FUNCTION f_media (p_empno emp.empno%type) RETURN NUMBER as
	v_media number(7,2);
BEGIN
	select avg(sal)
	into v_media
	from emp
	where deptno = (select deptno 
			from emp 
			where empno = p_empno);
	RETURN v_media;
END;
/
```

</details>

<summary>15</summary>

```sql
CREATE OR REPLACE PROCEDURE p_atualiza_emp (p_dname dept.dname%type) as
BEGIN
	update emp
	set func10 = 'S'
	where deptno = (select deptno
			from dept
			where dname = p_dname) AND (hiredate < '02-apr-2016');
END;
/
```

</details>

<summary>19.A</summary>


Isso cria a tabela retired_emps com a mesma estrutura da tabela emp. A tabela retired_emps eh criada vazia: 

```sql
create table retired_emps as 
select * from emp 
where rownum < 1;
```

Procedure:

```sql
CREATE OR REPLACE PROCEDURE ClassificaEmp as
	CURSOR emp_cursor IS 
		select ename, sal from emp;	

BEGIN
	FOR emp_record IN emp_cursor
	LOOP
		IF emp_record.sal > 2500 THEN
			DBMS_OUTPUT.PUT_LINE(to_char(emp_record.ename) ||': SALARIO ALTO');
		ELSE
			DBMS_OUTPUT.PUT_LINE(to_char(emp_record.ename) ||': SALARIO NORMAL');
		END IF;
	END LOOP;
END;
/
```

</details>

</details>

<summary>19.B</summary>

```sql
CREATE OR REPLACE PROCEDURE ClassificaEmp as
	CURSOR emp_cursor IS 
		select ename, sal from emp;	

BEGIN
	FOR emp_record IN emp_cursor
	LOOP
		IF emp_record.sal > 2500 THEN
			DBMS_OUTPUT.PUT_LINE(to_char(emp_record.ename) ||': SALARIO ALTO');
		ELSIF emp_record.sal > 1800 THEN
			DBMS_OUTPUT.PUT_LINE(to_char(emp_record.ename) ||': SALARIO MEDIO');
		ELSE
			DBMS_OUTPUT.PUT_LINE(to_char(emp_record.ename) ||': SALARIO BAIXO');
		END IF;
	END LOOP;
END;
/
```

</details>


</details>

<summary>19.C</summary>

```sql
CREATE OR REPLACE PROCEDURE AumentaSalario(p_sal emp.sal%type ) as
	CURSOR emp_cursor IS
	select * from emp
	where sal < p_sal;
	
	sal_novo emp.sal%type;

BEGIN
	FOR emp_record IN emp_cursor
	LOOP
		sal_novo := emp_record.sal * 1.1;

		update emp 
		set sal = sal_novo
		where empno = emp_record.empno;

		dbms_output.put_line('Cod: ' || emp_record.empno || 'Nome: ' || emp_record.ename || 'Antigo: ' || emp_record.sal || 'Novo: ' || sal_novo);

	END LOOP; 
	commit;
END;
/
```

</details>

</details>

<summary>19.D</summary>

```sql
CREATE OR REPLACE PROCEDURE AumentaSalario(p_sal emp.sal%type, p_perc number ) as
	CURSOR emp_cursor IS
	select * from emp
	where sal < p_sal;
	
	sal_novo emp.sal%type;

BEGIN
	FOR emp_record IN emp_cursor
	LOOP
		sal_novo := emp_record.sal * (p_perc / 100 + 1);

		update emp 
		set sal = sal_novo
		where empno = emp_record.empno;

		dbms_output.put_line('Cod: ' || emp_record.empno || 'Nome: ' || emp_record.ename || 'Antigo: ' || emp_record.sal || 'Novo: ' || sal_novo);

	END LOOP; 
	commit;
END;
/
```

</details>

<summary>22.A</summary>

```sql
-- Na linha select ename, sal, 1 seria ename, 2 seria sal

CREATE OR REPLACE PROCEDURE QuantasVezesMaior as
	CURSOR emp_cursor is
		select ename, sal
		from emp
		order by 2 desc; 

	v_maior_sal emp.sal%type;
	v_prop number;	

BEGIN
	select MAX(sal)
	into v_maior_sal
	from emp;

	for emp_record in emp_cursor
	LOOP
		v_prop := v_maior_sal / emp_record.sal;

		dbms_output.put_line('Nome		Salario			Proporcao');
		dbms_output.put_line(emp_record.ename || '		' || emp_record.sal || '			' || round(v_prop, 2));	
		dbms_output.put_line(chr(10));

	END LOOP;

END;
/
```

</details>

</details>

<summary>22.B</summary>

O salário de Matheus é 0, acarretando uma divisão por 0 (v_maior_sal / 0):
```
*
ERROR at line 1:
ORA-01476: divisor is equal to zero
ORA-06512: at "HR.QUANTASVEZESMAIOR", line 17
ORA-06512: at line 1
```

</details>


</details>

<summary>22.C</summary>

```sql
CREATE OR REPLACE PROCEDURE QuantasVezesMaior as
	CURSOR emp_cursor is
		select ename, sal
		from emp
		order by 2 desc; 

	v_maior_sal emp.sal%type;
	v_prop number;	

BEGIN
	select MAX(sal)
	into v_maior_sal
	from emp;

	for emp_record in emp_cursor
	LOOP
		BEGIN
			v_prop := v_maior_sal / emp_record.sal;

			dbms_output.put_line('Nome		Salario			Proporcao');
			dbms_output.put_line(emp_record.ename || '		' || emp_record.sal || '			' || round(v_prop, 2));	
			dbms_output.put_line(chr(10));

			EXCEPTION
				WHEN ZERO_DIVIDE THEN
					dbms_output.put_line('Nome		Salario			Proporcao');
					dbms_output.put_line(emp_record.ename || '		' || emp_record.sal || '			Salario Zerado');	
					dbms_output.put_line(chr(10));
		END;

	END LOOP;

END;
/
```

</details>



</details>

<summary>22.D</summary>

```sql
CREATE OR REPLACE PROCEDURE QuantasVezesMaior as
	CURSOR emp_cursor is
		select ename, sal
		from emp
		order by 2 desc; 

	v_maior_sal emp.sal%type;
	v_prop number;	

BEGIN
	select MAX(sal)
	into v_maior_sal
	from emp;

	for emp_record in emp_cursor
	LOOP
		BEGIN
			v_prop := v_maior_sal / emp_record.sal;

			dbms_output.put_line('Nome		Salario			Proporcao');
			dbms_output.put_line(emp_record.ename || '		' || emp_record.sal || '			' || round(v_prop, 2));	
			dbms_output.put_line(chr(10));

			EXCEPTION
				WHEN OTHERS THEN
					dbms_output.put_line('Nome		Salario			Proporcao');
					dbms_output.put_line(emp_record.ename || '		' || emp_record.sal || '			Salario Zerado');	
					dbms_output.put_line(chr(10));
		END;

	END LOOP;
	
END;
/
```

</details>