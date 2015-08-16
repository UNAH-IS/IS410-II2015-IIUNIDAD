package application;

import javafx.fxml.FXML;

public class PrincipalController {
	private Main main;
	
	@FXML public void abrirFormulario1(){
		main.abrirFormulario1();
	}
	
	@FXML public void abrirFormulario2(){
		main.abrirFormulario2();
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
