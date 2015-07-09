package modelo;

public class Lote {
	private int codigoLote;
	private String lote;
	public Lote(int codigoLote, String lote) {
		this.codigoLote = codigoLote;
		this.lote = lote;
	}
	
	public int getCodigoLote() {
		return codigoLote;
	}
	public void setCodigoLote(int codigoLote) {
		this.codigoLote = codigoLote;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	public String toString(){
		return lote;
	}
}
