package application;

import javafx.fxml.FXML;

public class Formulario1Controller {
	private Main main;

	@FXML
	public void abrirFormulario3(){
		main.abrirFormulario3();
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
