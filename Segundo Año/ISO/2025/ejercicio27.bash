#!/bin/bash

if [ $# -eq 0 ]; then
  echo "Parametros insuf"
  exit 1
fi

directorio="$1"

if [ -d "$directorio" ]; then
  cant=0
  cd "$directorio"
  for archivo in *; do
    if [[ -r "archivo" && -w "archivo" && ! -d "archivo" ]]; then
      cant=$((cant + 1))
    fi
  done
fi
