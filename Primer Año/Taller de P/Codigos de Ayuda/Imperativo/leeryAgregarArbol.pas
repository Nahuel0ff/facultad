program arboles;

type
	arbol = ^nodo;
	
	tipo = integer;
	
	nodo = record
		dato:tipo;
		HI:arbol;
		HD:arbol;
	end;

	
	procedure agregar (var a:arbol; num:integer);
	begin
		if (a=nil) then begin
			new(a);
			a^.dato:=num;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (num <= a^.dato) then agregar (a^.HI,num)
			else agregar (a^.HD,num);	
	end;


//Programa Principal
var
	a:arbol;
	num:integer;
BEGIN
	a:=nil;
	read(num);
	while (num <> 100) do begin
		agregar(a,num);
		read(num);
	end;
	
END.
