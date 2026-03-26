#!/bin/bash
declare -a PILA=()
TOP=-1  

push() {
    if [ $# -eq 1 ]; then
        ((TOP++))
        PILA[$TOP]="$1"
        echo "Elemento '$1' agregado a la pila"
    else
        echo "Error: push necesita exactamente 1 argumento"
    fi
}

pop() {
    if [ $TOP -ge 0 ]; then
        elemento="${PILA[$TOP]}"
        echo "Elemento '$elemento' sacado de la pila"
        unset PILA[$TOP]
        ((TOP--))
    else
        echo "La pila está vacía, no se puede sacar elementos"
    fi
}

length() {
    echo $((TOP + 1))
}

print() {
    if [ $TOP -lt 0 ]; then
        echo "La pila está vacía"
    else
        echo "Elementos en la pila (de base a tope):"
        for ((i=0; i<=$TOP; i++)); do
            echo "  [$i] ${PILA[$i]}"
        done
        
        echo -e "\nRepresentación vertical de la pila:"
        echo "  --- TOPE ---"
        for ((i=$TOP; i>=0; i--)); do
            echo "    ${PILA[$i]}"
        done
        echo "  --- BASE ---"
    fi
}

mostrar_estado() {
    echo -e "\n=================================================="
    echo "Longitud actual de la pila: $(length)"
    print
    echo "=================================================="
}

main() {
    
    echo -e "\n1. AGREGANDO 10 ELEMENTOS A LA PILA"
    for i in {1..10}; do
        push "Elemento $i"
    done
    
    mostrar_estado
    
    echo -e "\n2. SACANDO 3 ELEMENTOS DE LA PILA"
    for i in {1..3}; do
        pop
    done
    
    mostrar_estado
    
    echo -e "\n3. LONGITUD ACTUAL DE LA PILA"
    echo "La pila tiene $(length) elementos"
    
    echo -e "\n4. CONTENIDO COMPLETO DE LA PILA"
    print
    
}

main
