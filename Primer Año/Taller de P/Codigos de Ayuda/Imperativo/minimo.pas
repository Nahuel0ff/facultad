// Forma1

	function mini (a,b:integer):integer;
	begin
		if (a<b) then
			mini:=a
		else
			mini:=b;
	end;
			
	function minimo (l:lista):integer;
	begin
		if (l = nil) then
			minimo:=9999
		else
			minimo := mini(l^.dato,minimo(l^.sig));
	end;

 //Forma2
	function minimo (l:lista):integer;
	var
		minRest:integer;
	begin
		if (l = nil) then
			minimo:=999
		else begin
			minRest:=minimo(l^.sig);
			if (l^.dato < minRest) then 
				minimo:=l^.dato
			else
				minimo:=minRest;
		end;	
	end;
 
