#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Error: Falta el nombre de usuario"
    echo "Uso: $0 <usuario>"
    exit 1
fi

USUARIO="$1"

echo "Esperando que $USUARIO inicie sesión..."

while true
do
    if users | grep -w "$USUARIO" > /dev/null; then
        echo "Usuario $USUARIO logueado en el sistema"
        exit 0
    fi
    
    sleep 10
done
