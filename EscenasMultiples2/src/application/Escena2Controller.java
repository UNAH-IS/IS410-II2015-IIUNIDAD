package application;

import javafx.fxml.FXML;

public class Escena2Controller {
	private Main main;

	@FXML
	public void cambiarEscena1(){
		main.cambiarEscena1();
	}
	
	@FXML
	public void finalizar(){
		System.exit(0);
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
