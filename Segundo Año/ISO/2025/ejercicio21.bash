#!/bin/bash

if [ $# -eq 0 ];then
  echo "Requiere parametros"
  exit 1
fi

vector=("$@")

for ((i=0; i<${#vector#[@]}; i++)); do
  vector[$i]=$(( vector[$i] * 2))
done

#Test

echo "${vector[@]}"
