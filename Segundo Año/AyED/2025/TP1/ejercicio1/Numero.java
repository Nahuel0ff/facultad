/**
 * 
 */
/**
 * 
 */
package ejercicio1;

public class Numero {
	
	public static void usandoFor(int a, int b) {
			for (int i=a; i<=b; i++) {
				System.out.println(i);
			}
	}
	
	public static void usandoWhile(int a, int b) {
			int aux = a;
			while (aux <= b) {
				System.out.println(aux);
				aux++;
			}
	}
	
	public static void usandoMetodo(int a, int b) {
			if(b >= a) {
				System.out.println(a);
				usandoMetodo(a+1,b);
			}
	}
	
	public static void main (String [] args) {
		Numero.usandoFor(1, 4);
		Numero.usandoWhile(1, 4);
		Numero.usandoMetodo(1, 4);
	}
	
}