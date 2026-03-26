program ejercicio4;

const
  valorAlto = 9999;
  dimF = 5; // para probar

type
  producto = record
    codigo: integer;
    nombre: string;
    descripcion: string;
    stockDisponible: integer;
    stockMinimo: integer;
    precio: real;
  end;

  resumen = record
    codigo: integer;
    cantVendida: integer;
  end;

  archivoMaestro = file of producto;
  archivoDetalle = file of resumen;
  
  vectorArchivos = array[1..dimF] of archivoDetalle;
  vectorRegistros = array[1..dimF] of resumen;

// Procedimiento para leer detalle
procedure leer(var det: archivoDetalle; var reg: resumen);
begin
  if not eof(det) then
    read(det, reg)
  else
    reg.codigo := valorAlto; // si terminó ese detalle, ponemos valorAlto
end;

// Mínimo entre los detalles
procedure minimo(var v: vectorArchivos; var r: vectorRegistros; var min: resumen; var pos: integer);
var
  i: integer;
begin
  min.codigo := valorAlto;
  for i := 1 to dimF do
  begin
    if r[i].codigo < min.codigo then
    begin
      min := r[i];
      pos := i;
    end;
  end;
end;

// Actualizar maestro con los 30 detalles
procedure actualizarMaestro(var mae: archivoMaestro; var v: vectorArchivos);
var
  r: vectorRegistros;
  min: resumen;
  p: producto;
  pos: integer;
begin
  for pos := 1 to dimF do
  begin
    reset(v[pos]);
    leer(v[pos], r[pos]);
  end;

  reset(mae);

  minimo(v, r, min, pos);

  while min.codigo <> valorAlto do
  begin
    read(mae, p);
    while p.codigo <> min.codigo do
      read(mae, p);

    while min.codigo = p.codigo do
    begin
      p.stockDisponible := p.stockDisponible - min.cantVendida;
      leer(v[pos], r[pos]);
      minimo(v, r, min, pos);
    end;

    seek(mae, filepos(mae) - 1);
    write(mae, p);
  end;

  close(mae);
  for pos := 1 to dimF do
    close(v[pos]);
end;


procedure generarReporte(var mae: archivoMaestro);
var
  txt: Text;
  p: producto;
begin
  assign(txt, 'stock_bajo.txt');
  rewrite(txt);
  
  reset(mae);
  while not eof(mae) do
  begin
    read(mae, p);
    if p.stockDisponible < p.stockMinimo then
      writeln(txt, p.nombre, ' ', p.descripcion, ' Stock: ', p.stockDisponible, ' Precio: ', p.precio:0:2);
  end;
  
  close(mae);
  close(txt);
end;

// Programa Principal
var
  mae: archivoMaestro;
  v: vectorArchivos;
  i: integer;
  ruta: string;
begin
  assign(mae, 'maestro.dat');
  
  for i := 1 to dimF do
  begin
    str(i, ruta);
    assign(v[i], 'detalle' + ruta + '.dat');
  end;

  actualizarMaestro(mae, v);
  generarReporte(mae);

  writeln('Actualización finalizada y reporte generado');
end.
