package ejercicio9;

import java.util.*;

public class Ejercicio9 {

	public static boolean balanceado(String cad) {
		Stack<Character> pila = new Stack<>();
		for (char a : cad.toCharArray()) {
			if (a =='('|| a == '[' || a == '{') {
				pila.push(a);
			}else if(a == ')' || a== ']' || a == '}') {
				if(pila.isEmpty()) {
					return false;
				}
				char ult = pila.pop();
				if ((a == ')' && ult != '(') || (a == ']' && ult != '[') || (a == '}' && ult != '{')) {
					return false;
				}
			}
		}
		return pila.isEmpty();
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa un String");
		boolean result = Ejercicio9.balanceado(scanner.next());
		scanner.close();
		if(result) {
			System.out.println("El string ingresado está balanceado.");
		}else {
			System.out.println("El string ingresado no está balanceado");
		}
		
	}
	
	
	
}
