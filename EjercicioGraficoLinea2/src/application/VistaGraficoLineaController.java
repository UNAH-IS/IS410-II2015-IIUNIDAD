package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class VistaGraficoLineaController implements Initializable{
	@FXML private LineChart<String, Float> graficoLinea;
	
	private ObservableList<Data<String, Float>> informacion;
	private Series<String, Float> ventasMensuales;

	private ObservableList<Data<String, Float>> informacion2;
	private Series<String, Float> ventasMensuales2;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		informacion = FXCollections.observableArrayList();
		ventasMensuales = new Series<String, Float>();
		
		informacion2 = FXCollections.observableArrayList();
		ventasMensuales2 = new Series<String, Float>();
		
		informacion.add(new Data<String, Float>("Enero",123.5f));
		informacion.add(new Data<String, Float>("Febrero",500.5f));
		informacion.add(new Data<String, Float>("Marzo",50.5f));
		informacion.add(new Data<String, Float>("Abril",125.5f));
		//Enlazar observableList con Series
		ventasMensuales.setData(informacion);
		ventasMensuales.setName("Ventas mensuales 2015");
		//Agregar una serie(linea) a un grafico
		graficoLinea.getData().add(ventasMensuales);
		
		///Segunda serie
		
		informacion2.add(new Data<String, Float>("Enero",115.5f));
		informacion2.add(new Data<String, Float>("Febrero",400.5f));
		informacion2.add(new Data<String, Float>("Marzo",150.5f));
		informacion2.add(new Data<String, Float>("Abril",90.5f));
		//Enlazar observableList con Series
		ventasMensuales2.setData(informacion2);
		ventasMensuales2.setName("Ventas mensuales 2014");
		//Agregar una serie(linea) a un grafico
		graficoLinea.getData().add(ventasMensuales2);
	}
}
