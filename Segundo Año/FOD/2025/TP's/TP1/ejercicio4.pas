{
Agregar al menú del programa del ejercicio 3, opciones para:
a. Añadir uno o más empleados al final del archivo con sus datos ingresados por teclado. 
Tener en cuenta que no se debe agregar al archivo un empleado con un número de empleado ya registrado (control de unicidad).
b. Modificar la edad de un empleado dado.
c. Exportar el contenido del archivo a un archivo de texto llamado “todos_empleados.txt”.
d. Exportar a un archivo de texto llamado: “faltaDNIEmpleado.txt”, los empleados que no tengan cargado el DNI (DNI en 00).
   
}

program ejercicio4;

type
  empleado = record
    numemp: integer;
    ape: string;
    nom: string;
    edad: integer;
    dni: integer;
  end;

  archivo_emp = file of empleado;

procedure leerEmp(var e: empleado);
begin
  writeln('Ingrese apellido: ');
  readln(e.ape);
  if e.ape <> 'fin' then begin
    writeln('Ingrese num de emp: ');
    readln(e.numemp);
    writeln('Ingrese nombre: ');
    readln(e.nom);
    writeln('Ingrese edad: ');
    readln(e.edad);
    writeln('Ingrese DNI: ');
    readln(e.dni);
  end;
end;

procedure agregarEmpleado(var emp_log: archivo_emp);
var
  e, temp: empleado;
  existe: boolean;
begin
  reset(emp_log);
  leerEmp(e);
  while e.ape <> 'fin' do begin
    existe := false;
    while not EOF(emp_log) and not existe do begin
      read(emp_log, temp);
      if temp.numemp = e.numemp then
        existe := true;
    end;
    if not existe then begin
      seek(emp_log, FileSize(emp_log));
      write(emp_log, e);
      writeln('Empleado agregado correctamente.');
    end
    else
      writeln('Error: El numero de empleado ya existe.');
    leerEmp(e);
  end;
  close(emp_log);
end;

procedure modificarEdad(var emp_log: archivo_emp);
var
  e: empleado;
  numemp, nuevaEdad: integer;
  encontrado: boolean;
begin
  reset(emp_log);
  writeln('Ingrese el numero de empleado para modificar la edad: ');
  readln(numemp);
  encontrado := false;
  while not EOF(emp_log) and not encontrado do begin
    read(emp_log, e);
    if e.numemp = numemp then begin
      writeln('Ingrese la nueva edad: ');
      readln(nuevaEdad);
      e.edad := nuevaEdad;
      seek(emp_log, FilePos(emp_log) - 1);
      write(emp_log, e);
      encontrado := true;
    end;
  end;
  if encontrado then
    writeln('Edad modificada correctamente.')
  else
    writeln('Error: Empleado no encontrado.');
  close(emp_log);
end;

procedure exportarArchivo(var emp_log: archivo_emp);
var
  e: empleado;
  txt: text;
begin
  assign(txt, 'todos_empleados.txt');
  rewrite(txt);
  reset(emp_log);
  while not EOF(emp_log) do begin
    read(emp_log, e);
    writeln(txt, e.numemp, ' ', e.ape, ' ', e.nom, ' ', e.edad, ' ', e.dni);
  end;
  close(txt);
  close(emp_log);
  writeln('Archivo exportado correctamente.');
end;

procedure exportarDni(var emp_log: archivo_emp);
var
  e: empleado;
  txt: text;
begin
  assign(txt, 'faltaDniEmpleado.txt');
  rewrite(txt);
  reset(emp_log);
  while not EOF(emp_log) do begin
    read(emp_log, e);
    if e.dni = 0 then
      writeln(txt, e.numemp, ' ', e.ape, ' ', e.nom, ' ', e.edad, ' ', e.dni);
  end;
  close(txt);
  close(emp_log);
  writeln('Archivo de empleados sin DNI exportado correctamente.');
end;

procedure menu(var emp_log: archivo_emp);
var
  opcion: integer;
begin
  repeat
    writeln('Menu de opciones:');
    writeln('1. Agregar empleados.');
    writeln('2. Modificar edad de un empleado.');
    writeln('3. Exportar empleados a "todos_empleados.txt".');
    writeln('4. Exportar empleados sin DNI a "faltaDniEmpleado.txt".');
    writeln('5. Salir.');
    readln(opcion);
    case opcion of
      1: agregarEmpleado(emp_log);
      2: modificarEdad(emp_log);
      3: exportarArchivo(emp_log);
      4: exportarDni(emp_log);
    end;
  until opcion = 5;
end;

var
  emp_log: archivo_emp;
  nombreFisico: string;
begin
  writeln('Ingrese el nombre del archivo: ');
  readln(nombreFisico);
  assign(emp_log, nombreFisico);
  {$I-} reset(emp_log); {$I+}
  if IOResult <> 0 then
    rewrite(emp_log);
  menu(emp_log);
  close(emp_log);
end.
