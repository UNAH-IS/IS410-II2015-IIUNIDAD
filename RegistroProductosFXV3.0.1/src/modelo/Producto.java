package modelo;


//Java Bean = POJO
import java.sql.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {
	private IntegerProperty codigoProducto;
	private StringProperty codigoBarra;
	private StringProperty nombreProducto;
	private StringProperty descripcion;
	private DoubleProperty precioCompra;
	private DoubleProperty precioVenta;
	private Marca marca; //Composicion
	private Lote lote;//Composicion
	private Categoria categoria;//Composicion
	private UnidadMedida unidadMedida;//Composicion
	private Proveedor proveedor;//Composicion
	private FloatProperty existencia;
	private Date fechaVencimiento;
	private Moneda moneda;//Composicion
	
	public Producto(int codigoProducto, String codigoBarra,
			String nombreProducto, String descripcion, double precioCompra,
			double precioVenta, Marca marca, Lote lote, Categoria categoria,
			UnidadMedida unidadMedida, Proveedor proveedor, float existencia,
			Date fechaVencimiento, Moneda moneda) {
		this.codigoProducto = new SimpleIntegerProperty(codigoProducto);
		this.codigoBarra = new SimpleStringProperty(codigoBarra);
		this.nombreProducto = new SimpleStringProperty(nombreProducto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.precioCompra = new SimpleDoubleProperty(precioCompra);
		this.precioVenta = new SimpleDoubleProperty(precioVenta);
		this.marca = marca;
		this.lote = lote;
		this.categoria = categoria;
		this.unidadMedida = unidadMedida;
		this.proveedor = proveedor;
		this.existencia = new SimpleFloatProperty(existencia);
		this.fechaVencimiento = fechaVencimiento;
		this.moneda = moneda;
	}
	
	public int getCodigoProducto() {
		return codigoProducto.get();
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = new SimpleIntegerProperty(codigoProducto);
	}
	public IntegerProperty codigoProductoProperty(){
		return this.codigoProducto;
	}
	
	
	public String getCodigoBarra() {
		return codigoBarra.get();
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = new SimpleStringProperty(codigoBarra);
	}
	public StringProperty codigoBarraProperty(){
		return this.codigoBarra;
	} 
	
	public String getNombreProducto() {
		return nombreProducto.get();
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = new SimpleStringProperty(nombreProducto);
	}
	public StringProperty nombreProductoProperty(){
		return this.nombreProducto;
	} 
	
	
	public String getDescripcion() {
		return descripcion.get();
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = new SimpleStringProperty(descripcion);
	}
	public StringProperty descripcionProperty(){
		return this.descripcion;
	} 
	
	public double getPrecioCompra() {
		return precioCompra.get();
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = new SimpleDoubleProperty(precioCompra);
	}
	public DoubleProperty precioCompraProperty(){
		return this.precioCompra;
	} 
	
	
	public double getPrecioVenta() {
		return precioVenta.get();
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = new SimpleDoubleProperty(precioVenta);
	}
	public DoubleProperty precioVentaProperty(){
		return this.precioVenta;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
		
	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public float getExistencia() {
		return existencia.get();
	}
	public void setExistencia(float existencia) {
		this.existencia = new SimpleFloatProperty(existencia);
	}
	public FloatProperty existenciaProperty(){
		return this.existencia;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Moneda getMoneda() {
		return moneda;
	}
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	@Override
	public String toString() {
		return codigoProducto.get() + "\t\t"
				+ codigoBarra.get() + "\t\t"
				+ nombreProducto.get() + "\t\t"
				+ descripcion.get() + "\t\t"
				+ precioCompra.get() + "\t\t"
				+ precioVenta.get() +"\t\t"
				+ marca.toString() +  "\t\t"
				+ lote.toString() + "\t\t"
				+ categoria.toString() + "\t\t"
				+ unidadMedida.toString() + "\t\t"
				+ proveedor.toString() + "\t\t"
				+ existencia.get() + "\t\t"
				+ fechaVencimiento.toString() + "\t\t"
				+ moneda.toString();
	}	
}
