package final6;

public class Sector {
	private String nombre;
	private Empleado jefe;
	private Empleado[] empleados;
	private Producto[] productos;
	private int dimF;
	private int dimL;
	private int cantProd;
	private int cantMax;
	
	public Sector (String nom, int max) {
		this.nombre = nom;
		this.dimF= 50;
		this.dimL = 0;
		this.empleados= new Empleado[this.dimF];
		iniVecEmp(this.dimF);
		this.productos = new Producto[max];
		iniVecProd(max);
		this.jefe=null;
		this.cantProd=0;
		this.cantMax=max;
	}
	
	private void iniVecEmp(int max) {
		for(int i = 0; i<max;i++) {
			this.empleados[i]=null;
		}
	}
	
	private void iniVecProd (int max) {
		for(int i = 0; i < max; i++) {
			this.productos[i]=null;
		}
	}
	
	public void agregarEmpleado(Empleado emp, boolean esJefe) {
		if (esJefe) {
			this.jefe=emp;
		}else {
			if(this.dimL < this.dimF) {
				this.empleados[dimL]=emp;
				this.dimL++;
			}
		}
	}
	
	public void agregarProducto(Producto unProducto) {
		if (this.cantProd < this.cantMax) {
			this.productos[this.cantProd]=unProducto;
			this.cantProd++;
		}
	}
	
	public double costoTotal(int unaEtapa) {
		double aux = 0.0;
		for (int i = 0; i<this.cantProd;i++) {
			if (this.productos[i].getEtapa() == unaEtapa) {
				aux+= this.productos[i].getCostoT();
			}
		}
		return aux;
	}
	
	public void cambiarEtapa(int unCodProducto, double unCosto) {
		for (int i=0; i<this.cantProd; i++) {
			if (this.productos[i].getCodigo() == unCodProducto) {
				this.productos[i].setEtapa(this.productos[i].getEtapa()+1);
				this.productos[i].setCostoT(this.productos[i].getCostoT()+unCosto);
			}
		}
	}
	
	public String toString() {
		 double total = 0.0;
		 String aux ="Sector: "+ this.nombre + " datos del jefe: " + this.jefe.toString()+" cant de productos "+ this.cantProd+" costo etapa 5: ";
		 total=this.costoTotal(5);
		 aux+=total;
		 for (int i=0; i<this.dimL; i++) {
			 if (this.empleados[i].getAntiguedad() >= 10) {
				 aux+=this.empleados[i].toString();
			 }
		 }
				 
		return aux;
	}
	
	
}
