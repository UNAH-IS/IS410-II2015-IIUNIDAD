package modelo;

public class Categoria {
	private int codigoCategoria;
	private String categoria;
	
	public Categoria(int codigoCategoria, String categoria) {
		super();
		this.codigoCategoria = codigoCategoria;
		this.categoria = categoria;
	}
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String toString(){
		return categoria;
	}
}
