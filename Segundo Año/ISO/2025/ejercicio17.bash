#!/bin/bash
# Revisa todo el directorio y cambia los nombres de los archivos, de minuscula a mayuscula y al reves
ls -p | grep -v / | while read archivo
do
    echo "$archivo" | tr '[:lower:][:upper:]' '[:upper:][:lower:]' | tr -d 'aA'
done
