{
Realizar un programa que presente un menú con opciones para:
a. Crear un archivo de registros no ordenados de empleados y completarlo con datos ingresados desde teclado. 
De cada empleado se registra: número de empleado, apellido, nombre, edad y DNI. Algunos empleados se ingresan con DNI 00. 
La carga finaliza cuando se ingresa el String ‘fin’ como apellido.

b. Abrir el archivo anteriormente generado y
  i. Listar en pantalla los datos de empleados que tengan un nombre o apellido determinado, el cual se proporciona desde el teclado.
  ii. Listar en pantalla los empleados de a uno por línea.
  iii. Listar en pantalla los empleados mayores de 70 años, próximos a jubilarse.
   
}


program ejercicio3;

type
	empleado= record
		numemp:integer;
		ape:string;
		nom:string;
		edad:integer;
		dni:integer;
	end;

	archivo_emp = file of empleado;

procedure leerEmp (var e:empleado);
begin
	writeln('Ingrese apellido');
	readln(e.ape);
	if (e.ape <> 'fin') then begin
		writeln('Ingrese num de emp');
		readln(e.numemp);
		writeln('Ingrese nombre');
		readln(e.nom);
		writeln('Ingrese edad');
		readln(e.edad);
		writeln('Ingrese DNI ');
		readln(e.dni);
	end;
end;

procedure cargar (var emp_log:archivo_emp);
var
	e:empleado;
begin
	leerEmp(e);
	while (e.ape <> 'fin') do begin
		write(emp_log, e);
		leerEmp(e);
	end;
	close(emp_log);
end;

procedure leerArchivo (var emp_log:archivo_emp; var e:empleado);
begin
	if not EOF(emp_log) then
		read(emp_log,e);
end;

procedure imprimirReg (e:empleado);
begin
	writeln(e.nom);
	writeln(e.ape);
	writeln(e.edad);
	writeln(e.numemp);
	writeln(e.dni);
end;

procedure puntoBi (var emp_log:archivo_emp);
var
	e:empleado;
	nombre,apellido:string;
begin
	reset(emp_log); 
	writeln('Ingrese el nombre que desea buscar');
	readln(nombre);
	writeln('Ingrese el apellido que desea buscar');
	readln(apellido);
	leerArchivo(emp_log,e);
	while not EOF(emp_log) do begin
		if (e.nom = nombre) AND (e.ape = apellido) then begin
			imprimirReg(e);
		end;
		leerArchivo(emp_log,e);
	end;
	close(emp_log);
end;

procedure puntoBii (var emp_log: archivo_emp);
var
	e:empleado;
begin
	reset (emp_log);
	leerArchivo(emp_log,e);
	while not EOF(emp_log) do begin
		imprimirReg(e);
		leerArchivo(emp_log,e);
	end;
	close(emp_log);
end;

procedure puntoBiii (var emp_log: archivo_emp);
var
	e:empleado;
begin
	reset(emp_log);
	leerArchivo(emp_log,e);
	while not EOF(emp_log) do begin
		if (e.edad > 70) then
			imprimirReg(e);
		leerArchivo(emp_log,e);
	end;
	close(emp_log);
end;


var
	emp_log: archivo_emp;

BEGIN
	assign(emp_log, 'empleados_fis'); //Asignado
	rewrite(emp_log);                 //Creado
	cargar(emp_log);                  //Cargado y cerrado
	puntoBi(emp_log);                 //Punto B i
	puntoBii(emp_log);				  //Punto B ii
	puntoBiii(emp_log);				  //Punto B iii
END.

