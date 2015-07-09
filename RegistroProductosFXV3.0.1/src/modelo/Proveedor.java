package modelo;

public class Proveedor {
	private int codigoProveedor;
	private String nombreProveedor;
	
	public Proveedor(int codigoProveedor, String nombreProveedor) {
		this.codigoProveedor = codigoProveedor;
		this.nombreProveedor = nombreProveedor;
	}
	public int getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public String toString(){
		return nombreProveedor;
	}
}
