{
Realizar un algoritmo que cree un archivo de números enteros no ordenados y permita incorporar datos al archivo. 
Los números son ingresados desde teclado. La carga finaliza cuando se ingresa el número 30000, que no debe incorporarse al archivo. 
El nombre del archivo debe ser proporcionado por el usuario desde teclado.
}


program ejercicio1;

type
	archivo = file of integer;


procedure agregar (var arc:archivo; num:integer);
begin
	reset(arc);
	writeln('Ingrese un numero (si desea terminar, ingrese 30000)');
	read(num);
	while (num <> 30000) do begin
		write(arc,num);
		writeln('Ingrese un numero (si desea terminar, ingrese 30000)');
		read(num);
	end;
	close(arc);
end;


var 
	archivo_logico: archivo;
	num:integer;
	nombre:string;
BEGIN
	writeln('Ingrese el nombre del archivo fisico que desea');
	read(nombre);
	assign(archivo_logico, nombre);
	rewrite(archivo_logico);
	writeln('Ingrese un numero (si desea terminar, ingrese 30000)');
	read(num);
	write(archivo_logico,num);
	close(archivo_logico);
	agregar(archivo_logico,num);
END.

