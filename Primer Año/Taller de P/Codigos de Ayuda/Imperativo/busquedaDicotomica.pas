// Buscqueda de un numero en un vector

	procedure busquedaDicotomica (v:vector;ini,fin:indice;dato:integer; var pos:indice);
	var
		medio:integer;
	begin
		if (ini > fin) then	
			pos:=-1
		else begin
			medio:=(ini +fin) div 2;
			if (v[medio] = dato) then
				pos:=medio
			else if (v[medio] > dato) then
				busquedaDicotomica(v,ini,medio-1,dato,pos)
			else
				busquedaDicotomica(v,medio+1,fin,dato,pos);
		end;
	end;
