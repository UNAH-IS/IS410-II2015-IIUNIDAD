package application;

import java.net.URL;
import java.time.ZoneId;
import java.sql.Date;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Categoria;
import modelo.Conexion;
import modelo.Lote;
import modelo.Marca;
import modelo.Moneda;
import modelo.Producto;
import modelo.Proveedor;
import modelo.UnidadMedida;

public class RegistroProductosController implements Initializable{
	@FXML private TextField txtCodigoProducto; 
	@FXML private TextField txtCodigoBarras; 
	@FXML private TextField txtNombreProducto;
	@FXML private TextArea txtDescripcion;
	@FXML private TextField txtPrecioCompra; 
	@FXML private TextField txtPrecioVenta; 
	@FXML private TextField txtExistencia;
	@FXML private DatePicker dpFechaVencimiento;

	//@FXML private TextArea txtResultado;
	@FXML private Button btnActualizar;
	@FXML private Button btnEliminar;
	@FXML private Button btnGuardar;
	
	@FXML private ComboBox<Marca> cboMarca;
	@FXML private ComboBox<Lote> cboLote;
	@FXML private ComboBox<Categoria> cboCategoria;
	@FXML private ComboBox<UnidadMedida> cboUnidadMedida;
	@FXML private ComboBox<Proveedor> cboProveedor;
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
	private ObservableList<Lote> listaLotes;
	private ObservableList<Categoria> listaCategorias;
	private ObservableList<UnidadMedida> listaUnidadesMedidas;
	private ObservableList<Proveedor> listaProveedores;
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
		
		//Llenar la informacion
		tblInformacion.setItems(informacion);
		
		//Agregar Listener que permita identificar cuando se
		//selecciona un registro
		tblInformacion.getSelectionModel().
			selectedItemProperty().addListener(new ChangeListener<Producto>() {
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
					/*System.out.println("Se ejecuto changed");
					if (valorAnterior !=null && valorNuevo!=null){
						Alert mensaje = new Alert(AlertType.INFORMATION);
						mensaje.setContentText("Valor Anterior:" + valorAnterior.getNombreProducto()+"\n"+
									"Valor Nuevo:" + valorNuevo.getNombreProducto());
						mensaje.showAndWait();
					}*/
				}
				
			});
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
		dpFechaVencimiento.setValue(valorNuevo.getFechaVencimiento().toLocalDate());
		cboMoneda.getSelectionModel().select(valorNuevo.getMoneda());
		
		
	}
	
	public void llenarListas(){
		conexion.llenarInformacionMarca(listaMarcas);
		/*listaMarcas.add("Marca 1");
		listaMarcas.add("Marca 2");
		listaMarcas.add("Marca 3");*/
		
		conexion.llenarInformacionLote(listaLotes);
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
		
		
		conexion.llenarInformacionTableView(informacion);
		/*informacion.add(
				new Producto(
					123,
					"123456",
					"Producto por defecto",
					"Esta es la descripcion",
					123.12,
					125.12,
					new Marca(1,"Marca 1"),
					new Lote(1,"Lote 1"),
					new Categoria(1,"Categoria 1"),
					new UnidadMedida(1,"Unidad Medida 1"),
					new Proveedor(1,"Proveedor"),
					12,
					new Date(2015,12,1),
					new Moneda(1,"Lempiras","L.")
				));*/
		
		conexion.cerrarConexion();
	}
	
	@FXML
	public void agregarRegistro(){
		Producto p = new Producto(
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
				Date.valueOf(dpFechaVencimiento.getValue()),
				cboMoneda.getSelectionModel().getSelectedItem()
		);
		conexion.establecerConexion();
		int resultado = p.guardarRegistro(conexion);
		conexion.cerrarConexion();
		
		if (resultado==1){
			informacion.add(p);
			//JDK > 8u0.40
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText("Registro almacenado con exito");
			cuadroDialogo.setTitle("Registro agregado");
			cuadroDialogo.setHeaderText("Resultado:");
			cuadroDialogo.showAndWait();
			//actualizarResultado();
		}
	}
	
	@FXML
	public void actualizarRegistro(){
		Producto p = new Producto(
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
		);

		conexion.establecerConexion();
		int resultado = p.actualizarRegistro(conexion);
		conexion.cerrarConexion();
		
		if (resultado==1){
			informacion.set(
					tblInformacion.getSelectionModel().getSelectedIndex(),
					p
			);
			//JDK > 8u0.40
			Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
			cuadroDialogo.setContentText("Registro actualizado con exito");
			cuadroDialogo.setTitle("Registro Actualizado");
			cuadroDialogo.setHeaderText("Resultado:");
			cuadroDialogo.showAndWait();
		}
	}
	
	@FXML
	public void eliminarRegistro(){
		Alert cuadroDialogoConfirmacion = new Alert(AlertType.CONFIRMATION);
		cuadroDialogoConfirmacion.setTitle("Confirmacion");
		cuadroDialogoConfirmacion.setHeaderText("Eliminar registro");
		cuadroDialogoConfirmacion.setContentText("¿Esta seguro que desea eliminar este registro?");
		Optional<ButtonType> resultado = cuadroDialogoConfirmacion.showAndWait();
		if(resultado.get() == ButtonType.OK){
			Producto p = new Producto();
			p.setCodigoProducto(Integer.valueOf(txtCodigoProducto.getText()));
			conexion.establecerConexion();
			int r = p.eliminarRegistro(conexion);
			conexion.cerrarConexion();
			
			if (r==1){
				informacion.remove(tblInformacion.getSelectionModel().getSelectedIndex());
				limpiarComponentes();
				//JDK > 8u0.40
				Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
				cuadroDialogo.setContentText("Registro eliminado con exito");
				cuadroDialogo.setTitle("Registro Eliminado");
				cuadroDialogo.setHeaderText("Resultado:");
				cuadroDialogo.showAndWait();
			}
		}		
	}
	
	@FXML
	public void limpiarComponentes(){
		
		tblInformacion.getSelectionModel().select(null);
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
