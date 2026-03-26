#!/bin/bash

vector1=(1 80 65 35 2)
vector2?(5 98 33 41 8)

for ((i=0; i<$#vector1[@]}; i++)); do
  if (( i == 1 )); then
    echo "La suma de la posicion 1 es:$((vector1[i] + vector2[i]))"
  fi
  if (( i == 0 )); then
    echo "La suma de la posicion 1 es:$((vector1[i] + vector2[i]))"
  fi
  if (( i == 4 )): then
    echo "La suma de la posicion 1 es:$((vector1[i] + vector2[i]))"
  fi
done
