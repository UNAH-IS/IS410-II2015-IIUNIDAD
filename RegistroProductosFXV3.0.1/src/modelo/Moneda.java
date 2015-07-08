package modelo;

public class Moneda {
	private int codigoMoneda;
	private String nombreMoneda;
	private String abreviatura;
	public Moneda(int codigoMoneda, String nombreMoneda, String abreviatura) {
		this.codigoMoneda = codigoMoneda;
		this.nombreMoneda = nombreMoneda;
		this.abreviatura = abreviatura;
	}
	public int getCodigoMoneda() {
		return codigoMoneda;
	}
	public void setCodigoMoneda(int codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	public String getNombreMoneda() {
		return nombreMoneda;
	}
	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	public String toString(){
		return nombreMoneda + "(" + abreviatura + ")";
	}
}
