#!/bin/bash

if [ $# -eq 0 ]; then
  echo "Requiero parametros"
  exit 1
fi

vector=("$@")
cont=0

for num in "${vector[@]}"; do
  if (( num % 2 == 0 )); then  #Si es par, el mod da 0
    echo "$num"
  else                         #De lo contrario entra aca
    ((cont++))
  fi
done

echo "Cantidad de impares: $cont"
