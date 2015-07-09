package modelo;

public class UnidadMedida {
	private int codigoUnidadMedida;
	private String unidadMedida;
	public UnidadMedida(int codigoUnidadMedida, String unidadMedida) {
		this.codigoUnidadMedida = codigoUnidadMedida;
		this.unidadMedida = unidadMedida;
	}
	public int getCodigoUnidadMedida() {
		return codigoUnidadMedida;
	}
	public void setCodigoUnidadMedida(int codigoUnidadMedida) {
		this.codigoUnidadMedida = codigoUnidadMedida;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String toString(){
		return unidadMedida;
	}
}
