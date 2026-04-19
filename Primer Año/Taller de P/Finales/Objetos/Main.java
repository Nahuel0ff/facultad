package final6;

public class Main {

	public static void main(String[] args) {

		Sector sec = new Sector("Carlos",10);
		
		Empleado emp = new Empleado("Carlitos","Carl",20);
		Empleado emp2 = new Empleado("Jorge","George",1);
		Empleado emp3 = new Empleado("Miguel","Michael",5);
		
		Producto prod = new Producto(1);
		Producto prod2 = new Producto(2);
		
		sec.agregarEmpleado(emp, true);
		sec.agregarEmpleado(emp2, false);
		sec.agregarEmpleado(emp3, false);
		
		sec.agregarProducto(prod);
		sec.agregarProducto(prod2);
		
		sec.cambiarEtapa(1, 1);
		sec.cambiarEtapa(1, 1);
		sec.cambiarEtapa(1, 1);
		sec.cambiarEtapa(1, 1);
		
		
		System.out.println(sec.toString());
		
	}

}
