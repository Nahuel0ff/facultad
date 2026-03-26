{
Realizar un programa que permita:
a) Crear un archivo binario a partir de la información almacenada en un archivo de texto. 
El nombre del archivo de texto es: “novelas.txt”. La información en el archivo de texto consiste en: 
código de novela, nombre, género y precio de diferentes novelas argentinas. Los datos de cada novela se 
almacenan en dos líneas en el archivo de texto. La primera línea contendrá la siguiente información: código novela, 
precio y género, y la segunda línea almacenará el nombre de la novela.

b) Abrir el archivo binario y permitir la actualización del mismo. Se debe poder agregar una novela y modificar una existente. 
Las búsquedas se realizan por código de novela.
NOTA: El nombre del archivo binario es proporcionado por el usuario desde el teclado.   
   
}


program untitled;

type
	novela = record
		cod:integer;
		nom:string;
		genero:string;
		precio:real;
	end;
	
	archivo = file of novela;
	
procedure leer (var n:novela);
begin
	writeln('Ingrese el codigo: ');
	readln(n.cod);
	if (n.cod <> -1) then begin
		writeln('Ingrese el nombre: ');
		readln(n.nom);
		writeln('Ingrese el genero: ');
		readln(n.genero);
		writeln('Ingrese el precio: ');
		readln(n.precio);
	end;
end;
	
procedure cargar (var a:archivo);
var
	txt: Text;
	n: novela;
begin
	assign(txt, 'novelas.txt');
	reset(txt);
	rewrite(a);
	while not eof(a) do begin
		readln(txt, n.cod, n.precio, n.genero);
		readln(txt, n.nom);
		write(a,n);
	end;
	close(a);
	close(txt);
end;
	
procedure agregar (var a:archivo);
var
	n:novela;
	num:integer;
begin
	num:=1;
	reset(a);
	while (num <> 0) do begin
		seek(a,filesize(a));
		leer(n);
		write(a,n);
		write('Ingrese 0 para salir, cualquier otro numero para seguir agregando novelas.');
    readln(num);
	end;
	close(a);
end;

procedure modificar (var a:archivo);
var
	n:novela;
	id:integer;
	exito:boolean;
begin
	exito:=false;
	writeln('Ingrese el codifo de novela deseado: ');
	readln(id);
	reset(a);
	while not eof(a) AND (exito = false) do begin
		read(a,n);
		if (n.cod = id) then begin
			writeln('Se encontro, ingrese los nuevos datos');
			leer(n);
			seek(a,filepos(a) -1);
			write(a,n);
			exito:=true;
		end;
	end;
	close(a);
	if (exito) then 
		writeln('Se finalizo con exito')
	else
		writeln('No se encuentra la novela deseada');
end;

procedure imprimir (var a:archivo);
var
	n:novela;
begin
	reset(a);
	while not eof(a) do begin
		read(a,n);
		writeln(n.cod,n.nom,n.genero,n.precio);
	end;
	close(a);
end;
	
procedure menu( var a:archivo);
var
	menu:integer;
begin
	writeln('Ingresa una opcion');
	writeln('	1- Agregar novela');
	writeln('	2- Modificar novela');
	writeln('	3- Imprimir');
	writeln('	4- Finalizar');
	readln(menu);
	while (menu <> 4) do begin
		case(menu) of
		1:agregar(a);
		2:modificar(a);
		3:imprimir(a);
	end;
	writeln('Ingresa una opcion');
	writeln('	1- Agregar novela');
	writeln('	2- Modificar novela');
	writeln('	3- Imprimir');
	writeln('	4- Finalizar');
	readln(menu);
	end;
end;

var
	a:archivo;
	nom:string;
BEGIN
	write('Ingrese el nombre fisico del archivo: ');
	readln(nom);
	assign(a,nom);
	cargar(a);
	menu(a);	
END.

