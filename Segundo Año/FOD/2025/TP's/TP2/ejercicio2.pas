
program ejercicio2;

const
	valorAlto ='9999';

type
	
	prod = record
		cod:string[4];
		nom:string[30];
		precio:real;
		stockact:integer;
		stockmin:integer;
	end;
	
	venta = record
		cod:string[4];
		univend:integer;
	end;
	
	maestro = file of prod;
	
	detalle = file of venta;

//Lectura de maestro

	procedure leerProd (var p:prod);
	begin
		writeln('Ingrese el precio, para salir -1');
		readln(p.precio);
		if (p.precio <> -1) then begin
			writeln('Ingrese el codigo de prod: ');
			readln(p.cod);
			writeln('Ingrese el nombre del prod: ');
			readln(p.nom);
			writeln('Ingrese el stock actual del prod: ');
			readln(p.stockact);
			writeln('Ingrese el stock min del prod: ');
			readln(p.stockmin);
		end;
	end;
	
	procedure cargarMaestro (var m: maestro);
	var
		p:prod;
	begin
		rewrite(m);
		writeln('Ingrese un nuevo producto: ');
		leerProd(p);
		while (p.precio <> -1) do begin
			write(m,p);
			writeln('Ingrese un nuevo producto: ');
			leerProd(p);
		end;
		close(m);
	end;
	
//Lectura de Detalle
	procedure leerVenta (var v:venta);
	begin
		writeln('Ingresa las unidades vendidas, -1 para salir');
		readln(v.univend);
		if (v.univend <> -1) then begin
			writeln('Ingrese el codigo del prod vendido');
			readln(v.cod);
		end;
	end;

	procedure cargarDetalle(var d:detalle);
	var
		v:venta;
	begin
		rewrite(d);
		writeln('Ingrese el nuevo producto vendido: ');
		leerVenta(v);
		while (v.univend <> -1) do begin
			write(d,v);
			writeln('Ingrese el nuevo producto vendido: ');
			leerVenta(v);	
		end;
		close(d);
	end;
	
// Punto A
	procedure leerDetalle (var d:detalle; var v:venta);
	begin
		if not EOF(d) then
			read(d,v)
		else
			v.cod:=valorAlto;
	end;
	
	procedure modificarProd(var prod_nue:prod; c:integer; produ:prod);
	begin
		prod_nue.cod:=produ.cod;
		prod_nue.precio:=produ.precio;
		prod_nue.nom:=produ.nom;
		prod_nue.stockact:=produ.stockact + c;
		prod_nue.stockmin:=produ.stockmin;
	end;

	procedure procesarYActulizar(var m:maestro; var d:detalle);
	var
		prod_act:prod; //Maestro
		vent_act:venta;//Detalle
	begin
		reset(m);
		reset(d);
		
		leerDetalle(d,vent_act);
		
		while (vent_act.cod <> valorAlto) do begin
			read(m,prod_act);
			while(prod_act.cod <> vent_act.cod) do
				read(m,prod_act);                   //Busco en el maestro
				
			while (prod_act.cod = vent_act.cod) do begin
				prod_act.stockact:= prod_act.stockact - vent_act.univend;
				leerDetalle(d,vent_act);
			end;
			seek(m,filepos(m)-1);
			write(m,prod_act);                      
		end;
		close(d);
		close(m);
	end;
	
	procedure listarStockMinimo(var m: maestro);
	var
		p: prod;
		txt: text;
	begin
		assign(m, 'maestro.dat');
		reset(m);
		assign(txt, 'stock_minimo.txt');
		rewrite(txt);
	
		while not eof(m) do begin
			read(m, p);
			if (p.stockact < p.stockmin) then
				writeln(txt, 'Codigo: ', p.cod, ' Nombre: ', p.nom, ' Stock actual: ', p.stockact, ' Stock minimo: ', p.stockmin);
		end;
	
		close(m);
		close(txt);
	end;
	
// Para corroborar

procedure imprimirMaestro(var m: maestro);
var
	p: prod;
begin
	reset(m);
	writeln('----------------------------------------');
	while not eof(m) do begin
		read(m, p);
		writeln('Código: ', p.cod);
		writeln('Nombre: ', p.nom);
		writeln('Precio: $', p.precio:0:2);
		writeln('Stock actual: ', p.stockact);
		writeln('Stock mínimo: ', p.stockmin);
		writeln('----------------------------------------');
	end;
	close(m);
end;


	
//Programa principal
var
	m:maestro;
	d:detalle;
BEGIN
	assign(m,'maestro.dat');
	assign(d,'detalle.dat');
	cargarMaestro(m);
	cargarDetalle(d);
	writeln('Listado del archivo maestro sin actualizar:');
	imprimirMaestro(m);
	procesarYActulizar(m,d);
	writeln('Listado del archivo maestro actualizado:');
	imprimirMaestro(m);
	listarStockMinimo(m);
END.
