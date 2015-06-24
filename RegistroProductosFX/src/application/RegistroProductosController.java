package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	@FXML private RadioButton rbtLempiras;
	@FXML private RadioButton rbtDolares;
	@FXML private TextArea txtResultado;
	
	@FXML private ComboBox<String> cboMarca;
	@FXML private ComboBox<String> cboLote;
	@FXML private ComboBox<String> cboCategoria;
	@FXML private ComboBox<String> cboUnidadMedida;
	@FXML private ComboBox<String> cboProveedor;
	
	private ObservableList<String> listaMarcas;
	private ObservableList<String> listaLotes;
	private ObservableList<String> listaCategorias;
	private ObservableList<String> listaUnidadesMedidas;
	private ObservableList<String> listaProveedores;
	
	private ObservableList<Producto> informacion;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaMarcas = FXCollections.observableArrayList();
		listaLotes = FXCollections.observableArrayList();
		listaCategorias = FXCollections.observableArrayList();
		listaUnidadesMedidas = FXCollections.observableArrayList();
		listaProveedores = FXCollections.observableArrayList();
		informacion = FXCollections.observableArrayList();
		
		llenarListas();
		cboMarca.setItems(listaMarcas);
		cboLote.setItems(listaLotes);
		cboCategoria.setItems(listaCategorias);
		cboUnidadMedida.setItems(listaUnidadesMedidas);
		cboProveedor.setItems(listaProveedores);

		
	}
	
	public void llenarListas(){
		listaMarcas.add("Marca 1");
		listaMarcas.add("Marca 2");
		listaMarcas.add("Marca 3");
		
		listaLotes.add("Lote 1");
		listaLotes.add("Lote 2");
		listaLotes.add("Lote 3");
		
		listaCategorias.add("Categoria 1");
		listaCategorias.add("Categoria 2");
		listaCategorias.add("Categoria 3");

		listaUnidadesMedidas.add("Unidad medida 1");
		listaUnidadesMedidas.add("Unidad medida 2");
		listaUnidadesMedidas.add("Unidad medida 3");
		
		listaProveedores.add("Proveedor 1");
		listaProveedores.add("Proveedor 2");
		listaProveedores.add("Proveedor 3");
	}
	
	@FXML
	public void agregarRegistro(){
		/*Alert cuadroDialogo = new Alert(AlertType.INFORMATION);
		cuadroDialogo.setTitle("");
		cuadroDialogo.setContent("");
		cuadroDialogo.showAndWait();*/
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
					rbtLempiras.isSelected()?rbtLempiras.getText():rbtDolares.getText()
				)
		);
		actualizarResultado();
	}
	
	public void actualizarResultado(){
		txtResultado.setText(null);
		for(int i=0; i<informacion.size(); i++)
			txtResultado.appendText(informacion.get(i).toString());
	}
	
}
