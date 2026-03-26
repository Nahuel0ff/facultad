	procedure eliminar (var vec:vector; var DL:integer; par1,par2: integer);
	var
		pos1,pos2,i,j:integer;
	begin
	i:=1;
		while (i <= DL) AND (par1 > vec[i].codprod) do 
			i:=i+1;
		pos1:=i;
		while (i <= DL) AND (par2 >= vec[i].codprod) do
			i:=i+1;
		pos2:=i;
		
		for j:=pos2 to DL do
			vec[pos1 + (j-pos2)]:= vec[j];
			
		DL:= DL - (pos2 - pos1);		
	end;
