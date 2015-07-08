package modelo;

import java.util.Date;
//Java Bean = POJO
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
	private StringProperty lote;
	private StringProperty categoria;
	private StringProperty unidadMedida;
	private StringProperty proveedor;
	private FloatProperty existencia;
	private Date fechaVencimiento;
	private Moneda moneda;//Composicion
	
	public Producto(int codigoProducto, String codigoBarra,
			String nombreProducto, String descripcion, double precioCompra,
			double precioVenta, Marca marca, String lote, String categoria,
			String unidadMedida, String proveedor, float existencia,
			Date fechaVencimiento, Moneda moneda) {
		this.codigoProducto = new SimpleIntegerProperty(codigoProducto);
		this.codigoBarra = new SimpleStringProperty(codigoBarra);
		this.nombreProducto = new SimpleStringProperty(nombreProducto);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.precioCompra = new SimpleDoubleProperty(precioCompra);
		this.precioVenta = new SimpleDoubleProperty(precioVenta);
		this.marca = marca;
		this.lote = new SimpleStringProperty(lote);
		this.categoria = new SimpleStringProperty(categoria);
		this.unidadMedida = new SimpleStringProperty(unidadMedida);
		this.proveedor = new SimpleStringProperty(proveedor);
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
		
	public String getLote() {
		return lote.get();
	}
	public void setLote(String lote) {
		this.lote = new SimpleStringProperty(lote);
	}
	public StringProperty loteProperty(){
		return this.lote;
	}
	
	public String getCategoria() {
		return categoria.get();
	}
	public void setCategoria(String categoria) {
		this.categoria = new SimpleStringProperty(categoria);
	}
	public StringProperty categoriaProperty(){
		return this.categoria;
	}
	
	public String getUnidadMedida() {
		return unidadMedida.get();
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = new SimpleStringProperty(unidadMedida);
	}
	public StringProperty unidadMedidaProperty(){
		return this.unidadMedida;
	}
	
	public String getProveedor() {
		return proveedor.get();
	}
	public void setProveedor(String proveedor) {
		this.proveedor = new SimpleStringProperty(proveedor);
	}
	public StringProperty proveedorProperty(){
		return this.proveedor;
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
				+ lote.get() + "\t\t"
				+ categoria.get() + "\t\t"
				+ unidadMedida.get() + "\t\t"
				+ proveedor.get() + "\t\t"
				+ existencia.get() + "\t\t"
				+ fechaVencimiento.toString() + "\t\t"
				+ moneda.toString();
	}
	
	
}
