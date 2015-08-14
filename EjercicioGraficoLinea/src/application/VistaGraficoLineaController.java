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
	@FXML private LineChart<String,Float> graficoLinea;
	
	private ObservableList<Data<String,Float>> informacion;
	private Series<String,Float> serieVentasMensuales;
	
	private ObservableList<Data<String,Float>> informacion2;
	private Series<String,Float> serieVentasMensuales2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		informacion = FXCollections.observableArrayList();
		serieVentasMensuales= new Series<String,Float>();
		serieVentasMensuales.setName("Ventas mensuales 2015");
		informacion.add(new Data<String,Float>("Enero",145.5f));
		informacion.add(new Data<String,Float>("Febrero",300.5f));
		informacion.add(new Data<String,Float>("Marzo",150.3f));
		informacion.add(new Data<String,Float>("Abril",180.7f));
		//Enlazar observableList con Serie
		serieVentasMensuales.setData(informacion);
		//Enlazar grafico con serie
		graficoLinea.getData().add(serieVentasMensuales);
		
		informacion2 = FXCollections.observableArrayList();
		serieVentasMensuales2= new Series<String,Float>();
		serieVentasMensuales2.setName("Ventas mensuales 2014");
		informacion2.add(new Data<String,Float>("Enero",100.5f));
		informacion2.add(new Data<String,Float>("Febrero",450.5f));
		informacion2.add(new Data<String,Float>("Marzo",100.3f));
		informacion2.add(new Data<String,Float>("Abril",150.7f));
		//Enlazar observableList con Serie
		serieVentasMensuales2.setData(informacion2);
		//Enlazar grafico con serie
		graficoLinea.getData().add(serieVentasMensuales2);
		
	}
	
	
}
