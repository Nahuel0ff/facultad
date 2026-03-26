	procedure seleccion (var v:vector; DL:integer);
	var
		i,j,pos:integer;
		item:oficina;
	begin
		for i:=1 to DL-1 do begin
			pos:=i;
			for j:=i+1 to DL do
				if (v[j].id < v[pos].id) then
					pos:=j;
			item:=v[pos];
			v[pos]:=v[i];
			v[i]:=item;
		end;
	end;
