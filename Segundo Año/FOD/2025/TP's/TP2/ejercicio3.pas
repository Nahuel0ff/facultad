program ejercicio3;

const
	valorAlto = 'ZZZ';

type

	registro = record
		nom:string;
		cantAlf:integer;
		total:integer;
	end;
	
	registroDos = record
		nom:string;
		codLocal:integer;
		cantAlf:integer;
		total:integer;
	end;
	
	maestro = file of registro;
	
	detalle = file of registroDos;
	
	//Archivo Maestro
	
	procedure leerRegUno (var r:registro);
	begin
		read(r.nom);
		read(r.cantAlf);
		read(r.total);
	end;
	
	procedure cargarMaestro (var m:maestro);
	var
		r:registro;
	begin
		rewrite(m);
		leerRegUno(r);
		while (r.total <> -1) do begin
			write(m,r);
			leerRegUno(r);
		end;
		close(m);
	end;

	//Archivo Detalle
	
	procedure leerRegDos (var r:registroDos);
	begin
		read(r.nom);
		read(r.codLocal);
		read(r.cantAlf);
		read(r.total);
	end;
	
	procedure cargarDetalle (var d:detalle);
	var
		r:registroDos;
	begin
		rewrite(d);
		leerRegDos(r);
		while (r.total <> -1) do begin
			write(d,r);
			leerRegDos(r);
		end;
		close(d);
	end;

	// Procesar los archivos
	
	procedure leer (var d:detalle; var r:registroDos);
	begin
		if not EOF(d) then
			read(d,r)
		else
			r.nom:=valorAlto;
	end;
	
	procedure empezar (var d1:detalle; var d2:detalle; var rd:registroDos; var rd2:registroDos; var min:registroDos);
	begin
		if(rd.nom <= rd2.nom) then begin
			min:=rd;
			leer(d1,rd);
		end
		else begin
			min:=rd2;
			leer(d2,rd2);
		end;
	
	end;
	
	procedure actualizar (var m:maestro; var d1:detalle; var d2:detalle);
	var
		rd:registroDos;
		rd2:registroDos;
		min:registroDos;
		ru:registro;
	begin
		reset(m);
		reset(d1);
		reset(d2);
		leer(d1,rd);
		leer(d2,rd2);
		empezar(d1,d2,rd,rd2,min);
		while (min.nom <> valorAlto) do begin
			read(m,ru);
			while (min.nom <> ru.nom) do begin
				ru.cantAlf := ru.cantAlf + min.cantAlf;
				ru.total:= ru.total + min.total;
				empezar(d1,d2,rd,rd2,min);
			end;
			seek(m,filepos(m)-1);
			write(m,ru);
		end;		
		close(d2);
		close(d1);
		close(m);
	end;

var
	d1,d2:detalle;
	m:maestro;
	
BEGIN
	assign(m,'Maestro');
	assign(d1,'Detalle Uno');
	assign(d2,'Detalle Dos');
	cargarMaestro(m);
	cargarDetalle(d1);
	cargarDetalle(d2);
END.

