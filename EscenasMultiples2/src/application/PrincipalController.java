package application;

import javafx.fxml.FXML;

public class PrincipalController {
	private Main main;
	
	@FXML
	public void cambiarEscena2(){
		main.cambiarEscena2();
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
}
