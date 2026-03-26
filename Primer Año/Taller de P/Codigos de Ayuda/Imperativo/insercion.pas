	procedure insercion (var v:vector; DL:integer);
	var
		i,j:integer;
		actual:integer;
	begin
		for i:= 2 to DL do begin
			actual:=v[i].id;
			j:=i-1;
			while (j>0) AND (v[j].id > actual) do begin
				v[j+1]:=v[j];
				j:=j-1;
			end;
			v[j+1].id:=actual;
		end;	
	end;
