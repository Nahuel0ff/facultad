{
Realizar un programa para una tienda de celulares, que presente un menú con opciones para:
a. Crear un archivo de registros no ordenados de celulares y cargarlo con datos ingresados desde un archivo de texto denominado 
“celulares.txt”. Los registros correspondientes a los celulares deben contener: código de celular, nombre, descripción, marca, precio, 
stock mínimo y stock disponible.
b. Listar en pantalla los datos de aquellos celulares que tengan un stock menor al stock mínimo.
c. Listar en pantalla los celulares del archivo cuya descripción contenga una cadena de caracteres proporcionada por el usuario.
d. Exportar el archivo creado en el inciso a) a un archivo de texto denominado “celulares.txt” con todos los celulares del mismo. 
El archivo de texto generado
}


program ejercicio5;

type
	celular = record
		cod:integer;
		nom:string;
		desc:string;
		marca:string;
		precio:real;
		stkmin:integer;
		stkdisp:integer;
	end;
	
	archivo = file of celular; 

procedure cargarArchivo (var a: archivo);
var
	txt: Text;
	c: celular;
begin
	assign(txt, 'celulares.txt');
	reset(txt);
	rewrite(a);
	while (not eof(txt))do begin
		readln(txt, c.cod, c.precio, c.marca);
		readln(txt, c.stkdisp, c.stkmin, c.desc);
		readln(txt, c.nom);
		write(a,c);
	end;
	close(a);
	close(txt);
end;


function esMenor(min:integer; disp:integer):boolean;
begin
	if(min < disp) then
		esMenor:= true
	else
		esMenor:=false;
end;

procedure stockMenor (var a:archivo);
var
	c:celular;
begin
	reset(a);
	while not eof(a) do begin
	read(a,c);
		if (esMenor(c.stkmin,c.stkdisp)) then begin
			writeln('Codigo: ', c.cod,' Nombre: ', c.nom,' Marca: ', c.marca);
			writeln();
		end;
	end;
	close(a);
end;

procedure buscarDesc (var a:archivo);
var
	cad:string;
	ok:boolean;
	c:celular;
begin
	ok:=false;
	writeln('Ingrese la descripcion a buscar:');
	readln(cad);
	reset(a);
	while not eof(a) do begin
		read(a,c);
		if(pos(cad,c.desc) <> 0) then begin
			writeln('Cod: ',c.cod,' Nom: ', c.nom,' Precio: ', c.precio,' Marca: ', c.marca,' Stock Disp: ', c.stkdisp,' Stock Min: ', c.stkmin,' Desc: ', c.desc);
			ok:=true;
		end;
	end;
	if (ok = false) then
		writeln('No hay coincidencia en la desc ingresada');
	close(a);
end;


procedure exportar (var a:archivo);
var
	c:celular;
	txt: Text;
begin
	reset(a);
	assign(txt, 'celulares.txt');
	rewrite(txt);
	while not eof(a) do begin
		read(a,c);
		writeln(txt, c.cod, c.precio, c.marca);
		writeln(txt, c.stkdisp, c.stkmin, c.desc);
		writeln(txt, c.nom);
	end;
	close(txt);
	close(a);
	writeln('Finalizo el proceso');
end;

procedure menu (var a:archivo);
var
	menu:integer;
begin
	writeln('Ingrese una opcion: ');
	writeln('1-Listado en pantalla de productos en falta');
	writeln('2-Listado en pantalla de celulares descriptos');
	writeln('3-Exportar el listado de opcion 1 a "celulares.txt"');
	writeln('4-Salir del menu');
	readln(menu);
	while (menu <> 4) do begin
		case (menu) of
			1:stockMenor(a);
			2:buscarDesc(a);
			3:exportar(a);
		end;
		writeln('Ingrese una opcion: ');
		writeln('1-Listado en pantalla de productos en falta');
		writeln('2-Listado en pantalla de celulares descriptos');
		writeln('3-Exportar el listado de opcion 1 a "celulares.txt"');
		writeln('4-Salir del menu');
		readln(menu);
	end;
end;	

var
	a:archivo;
	nom:string;
BEGIN
	writeln('Ingrese el nombre del archivo fisico: ');
	readln(nom);
	assign(a, nom);
	cargarArchivo(a);
	menu(a);
END.

