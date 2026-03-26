package ejercicio4;

public class ejercicio4 {

	public static void swap1 (int x, int y) {
		 if (x < y) {
			 int tmp = x ;
			 x = y ;
			 y = tmp;
		 }
	}
	
	public static void swap2 (Integer x, Integer y) {
		 if (x < y) {
			 int tmp = x ;
			 x = y ;
			 y = tmp;
		 }
	}
	
	 public static void main(String[] args) {
		 int a = 1, b = 2;
		 Integer c = 3, d = 4;
		 swap1(a,b);
		 swap2(c,d);
		 
		 //Acá se imprime a = 1 b= 2 porque los parámetros son por valor y es una copia de la variable.
		 //por lo tanto todo lo que se cambie dentro del método no afecta a las variables originales
		 System.out.println("a=" + a + " b=" + b) ;
		 
		 //Acá se imprime c = 3 d= 4 porque sigue siendo un paso por valor, pero en este caso
		 //lo que se pasa es el valor de la referencia al objeto. La clase Integer es inmutable
		 //Por lo tanto las modificaciones dentro del metodo hace que los parametros apunten
		 //a otro objeto pero no modifica las variables originales
		 System.out.println("c=" + c + " d=" + d) ;
	}
	 
	 
	
	
}
