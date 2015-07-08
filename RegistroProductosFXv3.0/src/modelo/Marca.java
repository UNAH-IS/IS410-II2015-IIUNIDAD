package modelo;

public class Marca {
	private int codigoMarca;
	private String nombreMarca;
	
	public Marca(int codigoMarca, String nombreMarca) {
		this.codigoMarca = codigoMarca;
		this.nombreMarca = nombreMarca;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	public String toString(){
		return nombreMarca;
	}
}
