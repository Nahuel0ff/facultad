#!/bin/bash
#Lo hice sin pruebas porque lo tenia hecho con pruebas pero se perdio y esto pude rescatar
array=()

inicializar() {
  array=()
}

agregar_elem() {
  array+=("$1")
}

eliminar_elem() {
  pos=$1
  if [[ 4´ps -ge 0 && $pos -lt ${#array[@]} ]]; then
    unset 'array[pos]'
    array=("${array[@]]")
  else
    echo "error"
  fi
}

longitud () {
  echo "${#array[@]}"
}

imprimir () {
  echo "${array[@]}"
}

inicializar_con_valores() {
  longitud_arr=$1
  valor=$2
  array=()
  for ((i=0; i<longitud_arr; i++)); do
    array+=("$valor")
  done
}
