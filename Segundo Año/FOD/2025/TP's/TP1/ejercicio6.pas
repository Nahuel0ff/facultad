{
Agregar al menú del programa del ejercicio 5, opciones para:
a. Añadir uno o más celulares al final del archivo con sus datos ingresados por teclado.
b. Modificar el stock de un celular dado.
c. Exportar el contenido del archivo binario a un archivo de texto denominado: ”SinStock.txt”, con aquellos celulares que tengan stock 0.
NOTA: Las búsquedas deben realizarse por nombre de celular.
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
	
procedure leer(var c: celular);
begin
  write('Codigo: ');
  readln(c.cod);
  if(c.cod <> -1) then begin
    write('Nombre: ');
    readln(c.nom);
    write('Descripcion: ');
    readln(c.desc);
    write('Marca: ');
    readln(c.marca);
    write('Precio: ');
    readln(c.precio);
    write('Stock minimo: ');
    readln(c.stkmin);
    write('Stock Disponible: ');
    readln(c.stkdisp);
  end;
end;

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

procedure agregar(var a:archivo);
var
	c:celular;
	num:integer;
begin
	num:=1;
	reset(a);
	while (num <> 0) do begin
		seek(a,filesize(a));
		leer(c);
		write(a,c);
		writeln('Ingrese 0 si no quiere agregar mas celulares');
		readln(num);
	end;
	close(a);
end;

procedure modificarStock(var a:archivo);
var
	c:celular;
	id:integer;
	exito:boolean;
begin
	exito:= false;
	writeln('Ingrese el codigo del celular: ');
	readln(id);
	reset(a);
	while not eof(a) AND (exito = false) do begin
		read(a,c);
		if(c.cod = id) then begin
			exito:=true;
			writeln('Ingrese el nuevo stock: ');
			readln(c.stkdisp);
			seek(a,filepos(a)-1);
			write(a,c);
		end;
	end;
	if (exito) then
		writeln('Datos modificados')
	else
		writeln('El celular no existe.');
end;

procedure exportarSinStock (var a:archivo);
var
	c:celular;
	txt: Text;
begin
	reset(a);
	assign(txt, 'SinStock.txt');
	rewrite(txt);
	while not eof(a) do begin
		read(a,c);
		if(c.stkdisp = 0) then begin
			writeln(txt, c.cod, c.precio, c.marca);
			writeln(txt, c.stkdisp, c.stkmin, c.desc);
			writeln(txt, c.nom);
		end;
	end;
	close(txt);
	close(a);
end;



procedure menu (var a:archivo);
var
	menu:integer;
begin
	writeln('Ingrese una opcion: ');
	writeln('1-Listado en pantalla de productos en falta');
	writeln('2-Listado en pantalla de celulares descriptos');
	writeln('3-Exportar el listado de opcion 1 a "celulares.txt"');
	writeln('4-Agregar celulares');
	writeln('5-Modificar stock de un celular');
	writeln('6-Exportar contenido de los celulares sin stock');
	writeln('7-Salir del menu');
	readln(menu);
	while (menu <> 7) do begin
		case (menu) of
			1:stockMenor(a);
			2:buscarDesc(a);
			3:exportar(a);
			4:agregar(a);
			5:modificarStock(a);
			6:exportarSinStock(a);
		end;
		writeln('Ingrese una opcion: ');
		writeln('1-Listado en pantalla de productos en falta');
		writeln('2-Listado en pantalla de celulares descriptos');
		writeln('3-Exportar el listado de opcion 1 a "celulares.txt"');
		writeln('4-Agregar celulares');
		writeln('5-Modificar stock de un celular');
		writeln('6-Exportar contenido de los celulares sin stock');
		writeln('7-Salir del menu');
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

