#!/bin/bash

usuarios_grupo()

cargar_usuarios() {
  if linea_grupo=$(grep "^users:" /etc/group 2>/dev/null); then
    lista_usuarios=$(echo "$linea_grupo" | cut -d ',' -f4)
    usuarios_grupo=($(echo "$lista_usuarios" | tr ',' '\n'))
  else
    echo "Error"
    exit 1
  fi
}
cargar_usuarios

case $1 in
  "-b")
    posicion=$2
    if [[ ! "$posicion" =~ ^[0-9]+$ ]]; then
      echo "Error"
      exit 1
    fi
    if [ $posicion -lt ${#usuarios_grupo[@]} ] && [ $posicion -ge 0 ]; then
      echo "${usuarios_grupo[$posicion]}"
    else
      echo "Error"
      exit 1
    fi
    ;;
    "-l")
      echo "${#usuarios_grupo[@]"
      ;;
    "-i")
      for usuario in "${usuario_grupo[@]}"; do
        echo "$usuario"
      done
      ;;
    *)
      echo "Opciones:"
      echo "   -b n Mostrar usuario en la posición n"
      echo "   -l   Mostrar cantidad de usuarios"
      echo "   -i   Listar todos los usuarios"
      exit 1
      ;;
    esac
