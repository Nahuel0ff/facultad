#!/bin/bash

vector ( $(ls -A)

verArchivo() {
  local parametro=$1
  local indice=0
  local encontrado=false

  while [[ "$encontrado" == "false" ]] && (( indice < ${#vector[*]} )); do
    if [[ "${vector[indice]}" == "$parametro" ]]; then
      echo $parametro"
      econtrado="true"
      return 0
    fi
    ((indice++))
  done
  if [[ "$encontrado" == "false" ]]; then
    echo "No esta en el vector pa"
    return 5
  fi
}

cantArchivos() {
  echo "${#vector[*]}"
  return 0
}

borrarArchivo() {
  local parametro="$1"

  verArhivo"$parametro"
  local resultado=$?

  if [resultado -ne 0 ]; then
    echo "No se puede borrar"
    return 10
  else
    read -r -p "Ingresa Si si desea borrar del sistema, No, si no lo desea: " rta
    local i=0
    locar borrado="false"
    while [[ "$borrado" == "false" ]] && (( i < ${#vector[*]} )); do
      if [[ "${vector[i]}" == "$parametro" ]]; then
      unset 'vector[i]'
      borrado="true"
      echo "Eliminado"

      if [[ "$rta" =~ ^[Ss][Ii]$ ]]; then
        rm "$parametro"
        if [ $? -eq 0 ]; then
          echo "Eliminado"
        else
          echo "Fallo al eliminar"
        fi
      else
        echo "Se conservo el archivo"
      fi
    fi
    ((i++))
  done

  vector=("${vector[@]}")

  return 0
  fi
}
