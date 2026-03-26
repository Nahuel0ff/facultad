#Lo probe con /home/linux /tmp /etc /var /home/linux/Escritorio/practica-shell-script/ejercicio25.sh y dieron verdadero
# /log y /hola dieron que no existe

#!/bin/bash
if [ $# -eq 0 ]; then
  echo "Error de parametros"
  exit 1
fi

contador=0
indice=1

for ruta in "$@"; do
  if
    if [ -f "ruta" ]; then
      echo "[$indice]'$ruta' es un Archivo"
    elif [ -d "$ruta" ]; then
      echo"[$indice]'$ruta' es un directorio"
    else
      echo"[$indice]'$ruta' No existe"
      ((contador++))
    fi
  fi
  ((indice++))
done
echo "- - - - - - -"
echo "Total de inex: $contador"
