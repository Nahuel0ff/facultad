package final6;

public class Producto {
	private int codigo;
	private double costoT;
	private int etapa;
	
	public Producto (int cod) {
		this.codigo = cod;
		this.costoT = 0.0;
		this.etapa = 1;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getCostoT() {
		return costoT;
	}

	public void setCostoT(double costoT) {
		this.costoT = costoT;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
	
	
	
}
