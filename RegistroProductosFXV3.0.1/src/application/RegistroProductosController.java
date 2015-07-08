package application;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Conexion;
import modelo.Marca;
import modelo.Moneda;
import modelo.Producto;

public class RegistroProductosController implements Initializable{
	@FXML private TextField txtCodigoProducto; 
	@FXML private TextField txtCodigoBarras; 
	@FXML private TextField txtNombreProducto;
	@FXML private TextArea txtDescripcion;
	@FXML private TextField txtPrecioCompra; 
	@FXML private TextField txtPrecioVenta; 
	@FXML private TextField txtExistencia;
	@FXML private DatePicker dpFechaVencimiento;
	
	@FXML private Button btnActualizar;
	@FXML private Button btnEliminar;
	@FXML private Button btnGuardar;
	
	@FXML private ComboBox<Marca> cboMarca;
	@FXML private ComboBox<String> cboLote;
	@FXML private ComboBox<String> cboCategoria;
	@FXML private ComboBox<String> cboUnidadMedida;
	@FXML private ComboBox<String> cboProveedor;
	@FXML private ComboBox<Moneda> cboMoneda;
	
	@FXML private TableView<Producto> tblInformacion;
	
	@FXML private TableColumn<Producto,Number> clmnCodigoProducto;
	@FXML private TableColumn<Producto,String> clmnCodigoBarras;
	@FXML private TableColumn<Producto,String> clmnNombreProducto;
	@FXML private TableColumn<Producto,Number> clmnPrecioCompra;
	@FXML private TableColumn<Producto,Number> clmnPrecioVenta;
	@FXML private TableColumn<Producto,String> clmnMarca;
	@FXML private TableColumn<Producto,String> clmnLote;
	@FXML private TableColumn<Producto,String> clmnCategoria;
	@FXML private TableColumn<Producto,String> clmnUnidadMedida;
	@FXML private TableColumn<Producto,String> clmnProveedor;
	@FXML private TableColumn<Producto,Number> clmnExistencia;
	@FXML private TableColumn<Producto,Date> clmnFechaVencimiento;
	@FXML private TableColumn<Producto,String> clmnMoneda;
	
	
	private ObservableList<Marca> listaMarcas;
	private ObservableList<String> listaLotes;
	private ObservableList<String> listaCategorias;
	private ObservableList<String> listaUnidadesMedidas;
	private ObservableList<String> listaProveedores;
	private ObservableList<Moneda> listaMonedas;
	
	private ObservableList<Producto> informacion;
	
	private Conexion conexion;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = new Conexion(); 
		listaMarcas = FXCollections.observableArrayList();
		listaLotes = FXCollections.observableArrayList();
		listaCategorias = FXCollections.observableArrayList();
		listaUnidadesMedidas = FXCollections.observableArrayList();
		listaProveedores = FXCollections.observableArrayList();
		informacion = FXCollections.observableArrayList();
		listaMonedas = FXCollections.observableArrayList();
		
		llenarListas();
		cboMarca.setItems(listaMarcas);
		cboLote.setItems(listaLotes);
		cboCategoria.setItems(listaCategorias);
		cboUnidadMedida.setItems(listaUnidadesMedidas);
		cboProveedor.setItems(listaProveedores);
		cboMoneda.setItems(listaMonedas);

		
		//Enlazar las columnas del tableview con los 
		//respectivos atributos de la clase Producto
		//El String tiene que coincidir con el nombre del atributo correspondiente
		clmnCodigoProducto.setCellValueFactory(
				new PropertyValueFactory<Producto,Number>("codigoProducto")
		);
		clmnCodigoBarras.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("codigoBarra")
		);
		clmnNombreProducto.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("nombreProducto")
		);
		clmnPrecioCompra.setCellValueFactory(
				new PropertyValueFactory<Producto,Number>("precioCompra")
		);
		clmnPrecioVenta.setCellValueFactory(
				new PropertyValueFactory<Producto,Number>("precioVenta")
		);
		clmnMarca.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("marca")
		);
		clmnLote.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("lote")
		);
		clmnCategoria.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("categoria")
		);
		clmnUnidadMedida.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("unidadMedida")
		);
		clmnProveedor.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("proveedor")
		);
		clmnExistencia.setCellValueFactory(
				new PropertyValueFactory<Producto,Number>("existencia")
		);
		clmnMoneda.setCellValueFactory(
				new PropertyValueFactory<Producto,String>("moneda")
		);
		clmnExistencia.setCellValueFactory(
				new PropertyValueFactory<Producto,Number>("existencia")
		);
		clmnFechaVencimiento.setCellValueFactory(
				new PropertyValueFactory<Producto,Date>("fechaVencimiento")
		);
		tblInformacion.setItems(informacion);
		
		
		tblInformacion.
			getSelectionModel().
			selectedItemProperty().
			addListener(
					new ChangeListener<Producto>() {
						@Override
						public void changed(
								ObservableValue<? extends Producto> arg0,
								Producto valorAnterior, 
								Producto valorNuevo) {
							btnActualizar.setDisable(false);
							btnEliminar.setDisable(false);
							if (valorNuevo != null){
								btnGuardar.setDisable(true);
								llenarComponentes(valorNuevo);
							}
							/*if (valorAnterior !=null && valorNuevo!=null){
								Alert mensaje = new Alert(AlertType.INFORMATION);
								mensaje.setHeaderText("Se selecciono un registro");
								mensaje.setContentText(
										"Valor anterior:"+valorAnterior.getNombreProducto()+"\n"
										+ "Valor nuevo:"+valorNuevo.getNombreProducto());
								mensaje.showAndWait();
							}*/
						}
					}
			);
	}
	
	public void llenarComponentes(Producto valorNuevo){
		txtCodigoProducto.setText(String.valueOf(valorNuevo.getCodigoProducto()));
		txtCodigoBarras.setText(valorNuevo.getCodigoBarra());
		txtNombreProducto.setText(valorNuevo.getNombreProducto());
		txtDescripcion.setText(valorNuevo.getDescripcion());
		txtPrecioCompra.setText(String.valueOf(valorNuevo.getPrecioCompra()));
		txtPrecioVenta.setText(String.valueOf(valorNuevo.getPrecioVenta()));
		cboMarca.getSelectionModel().select(valorNuevo.getMarca());
		cboLote.getSelectionModel().select(valorNuevo.getLote());
		cboCategoria.getSelectionModel().select(valorNuevo.getCategoria());
		cboUnidadMedida.getSelectionModel().select(valorNuevo.getUnidadMedida());
		cboProveedor.getSelectionModel().select(valorNuevo.getProveedor());
		txtExistencia.setText(String.valueOf(valorNuevo.getExistencia()));
		dpFechaVencimiento.setValue(valorNuevo.getFechaVencimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		cboMoneda.getSelectionModel().select(valorNuevo.getMoneda());
	}
	
	public void llenarListas(){
		conexion.llenarInformacionMarcas(listaMarcas);
		/*listaMarcas.add("Marca 1");
		listaMarcas.add("Marca 2");
		listaMarcas.add("Marca 3");*/
		
		conexion.llenarInformacionLotes(listaLotes);
		/*listaLotes.add("Lote 1");
		listaLotes.add("Lote 2");
		listaLotes.add("Lote 3");*/
		
		conexion.llenarInformacionCategorias(listaCategorias);
		/*listaCategorias.add("Categoria 1");
		listaCategorias.add("Categoria 2");
		listaCategorias.add("Categoria 3");*/

		conexion.llenarInformacionUnidadMedida(listaUnidadesMedidas);
		/*listaUnidadesMedidas.add("Unidad medida 1");
		listaUnidadesMedidas.add("Unidad medida 2");
		listaUnidadesMedidas.add("Unidad medida 3");*/
		
		conexion.llenarInformacionProveedores(listaProveedores);
		/*listaProveedores.add("Proveedor 1");
		listaProveedores.add("Proveedor 2");
		listaProveedores.add("Proveedor 3");*/
		
		conexion.llenarInformacionMoneda(listaMonedas);
		
		informacion.add(
				new Producto(
					132,
					"123456789",
					"Producto 1",
					"Esta es la descripcion",
					456,
					500,
					new Marca(1,"Marca 1"),
					"Lote 1",
					"Categoria 1",
					"Unidad Medida 1",
					"Proveedor 1",
					123,
					new Date(),
					new Moneda(1,"Lempiras","L.")
				)
		);
		
		conexion.cerrarConexion();
	}
	
	@FXML
	public void agregarRegistro(){
		informacion.add(
				new Producto(
					Integer.valueOf(txtCodigoProducto.getText()),
					txtCodigoBarras.getText(),
					txtNombreProducto.getText(),
					txtDescripcion.getText(),
					Double.valueOf(txtPrecioCompra.getText()),
					Double.valueOf(txtPrecioVenta.getText()),
					cboMarca.getSelectionModel().getSelectedItem(),
					cboLote.getSelectionModel().getSelectedItem(),
					cboCategoria.getSelectionModel().getSelectedItem(),
					cboUnidadMedida.getSelectionModel().getSelectedItem(),
					cboProveedor.getSelectionModel().getSelectedItem(),
					Float.valueOf(txtExistencia.getText()),
					new Date(dpFechaVencimiento.getValue().toEpochDay()),
					cboMoneda.getSelectionModel().getSelectedItem()
				)
		);
		//JDK > 8u0.40
		Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
		cuadroDialogo.setContentText("El registro se almaceno con exito.");
		cuadroDialogo.setTitle("Resultado");
		cuadroDialogo.setHeaderText("Resultado:");
		cuadroDialogo.showAndWait();
		//actualizarResultado();
	}
	
	@FXML
	public void actualizarRegistro(){
		informacion.set(
				tblInformacion.getSelectionModel().getSelectedIndex(),
				new Producto(
					Integer.valueOf(txtCodigoProducto.getText()),
					txtCodigoBarras.getText(),
					txtNombreProducto.getText(),
					txtDescripcion.getText(),
					Double.valueOf(txtPrecioCompra.getText()),
					Double.valueOf(txtPrecioVenta.getText()),
					cboMarca.getSelectionModel().getSelectedItem(),
					cboLote.getSelectionModel().getSelectedItem(),
					cboCategoria.getSelectionModel().getSelectedItem(),
					cboUnidadMedida.getSelectionModel().getSelectedItem(),
					cboProveedor.getSelectionModel().getSelectedItem(),
					Float.valueOf(txtExistencia.getText()),
					new Date(dpFechaVencimiento.getValue().toEpochDay()),
					cboMoneda.getSelectionModel().getSelectedItem()
				)
		);
		//JDK > 8u0.40
		Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
		cuadroDialogo.setContentText("El registro se actualizo con exito.");
		cuadroDialogo.setTitle("Resultado");
		cuadroDialogo.setHeaderText("Resultado:");
		cuadroDialogo.showAndWait();
	}
	
	@FXML
	public void eliminarRegistro(){
		informacion.remove(tblInformacion.getSelectionModel().getSelectedIndex());
		limpiarComponentes();
		//JDK > 8u0.40
		Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
		cuadroDialogo.setContentText("El registro se elimino con exito.");
		cuadroDialogo.setTitle("Resultado");
		cuadroDialogo.setHeaderText("Resultado:");
		cuadroDialogo.showAndWait();
	}
	
	@FXML
	public void limpiarComponentes(){
		txtCodigoProducto.setText(null);
		txtCodigoBarras.setText(null);
		txtNombreProducto.setText(null);
		txtDescripcion.setText(null);
		txtPrecioCompra.setText(null);
		txtPrecioVenta.setText(null);
		cboMarca.getSelectionModel().select(null);
		cboLote.getSelectionModel().select(null);
		cboCategoria.getSelectionModel().select(null);
		cboUnidadMedida.getSelectionModel().select(null);
		cboProveedor.getSelectionModel().select(null);
		txtExistencia.setText(null);
		dpFechaVencimiento.setValue(null);
		cboMoneda.getSelectionModel().select(null);
		tblInformacion.getSelectionModel().select(null);
		//Para evitar un bug de que no se desactiven
		//mejor hacerlo al final del metodo
		btnActualizar.setDisable(true);
		btnEliminar.setDisable(true);
		btnGuardar.setDisable(false);
	}
	
	/*public void actualizarResultado(){
		txtResultado.setText(null);
		for(int i=0; i<informacion.size(); i++)
			txtResultado.appendText(informacion.get(i).toString()+"\n");
	}*/
}
