
program ejercicio1;

type
	empleado = record
		cod:integer;
		nom:string;
		monto:real;
	end;

	archivo = file of empleado;
	
	procedure leerEmp(var e:empleado);
	begin
		writeln('Ingrese el monto del empleado, -1 para salir');
		readln(e.monto);
		if (e.monto <> -1) then begin
			writeln('Ingrese el codigo del empleado: ');
			readln(e.cod);
			writeln('Ingrese el nombre del empleado: ');
			readln(e.nom);
		end;
	end;
	
	procedure agregarEmp (var a:archivo);
	var
		e:empleado;
	begin
		rewrite(a);
		leerEmp(e);
		while (e.monto <> -1) do begin
			write(a,e);
			writeln('Ingrese un nuevo empleado: ');
			leerEmp(e);
		end;
	close(a);
	end;
	
	procedure crearNuevoEmp (var en:empleado; m:real; e:empleado);
	begin
		en.cod:=e.cod;
		en.nom:=e.nom;
		en.monto:=m;
	end;
	
	procedure leerArc (var a:archivo;var e:empleado);
	begin
		if not EOF(a) then
			read(a,e)
		else
			e.cod:= -1;
	end;
	
	procedure leerYCrear(var a: archivo; var a2: archivo);
	var
		emp_temp, emp_act, emp_nue: empleado;
		sumador: real;
	begin
		reset(a);
		rewrite(a2);
		leerArc(a, emp_act); // usar el procedimiento leer
		while (emp_act.cod <> -1) do begin
			emp_temp := emp_act;
			sumador := 0;
			while (emp_act.cod = emp_temp.cod) and (emp_act.cod <> -1) do begin
				sumador := sumador + emp_act.monto;
				leerArc(a, emp_act);
			end;
			crearNuevoEmp(emp_nue, sumador, emp_temp);
			write(a2, emp_nue);
		end;
		close(a2);
		close(a);
	end;

	
	procedure imprimir (var a2:archivo);
	var
		e:empleado;
	begin
		reset(a2);
		while not EOF(a2) do begin
			read(a2,e);
			writeln('El codigo es ', e.cod);
			writeln('El nombre es ', e.nom);
			writeln('El monto es ', e.monto:0:2);
		end;
		close(a2); 
	end;
	
var
a,a2: archivo;

BEGIN
	assign(a, 'Prueba');
	assign(a2, 'Prueba2');
	agregarEmp(a);
	leerYCrear(a,a2);
	imprimir(a2);
END.

