package modelo;

/* Java Bean
* Clase: Alumno  */
import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Alumno{
	private IntegerProperty codigoAlumno;
	private StringProperty nombre;
	private StringProperty apellido;
	private IntegerProperty edad;
	private StringProperty genero;
	private Date fechaIngreso;
	private CentroEstudio centroEstudio;
	private Carrera carrera;

	public Alumno(Integer codigoAlumno, String nombre, String apellido, Integer edad, String genero, Date fechaIngreso, CentroEstudio centroEstudio, Carrera carrera){
		this.codigoAlumno = new SimpleIntegerProperty(codigoAlumno);
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		this.edad = new SimpleIntegerProperty(edad);
		this.genero = new SimpleStringProperty(genero);
		this.fechaIngreso = fechaIngreso;
		this.centroEstudio = centroEstudio;
		this.carrera = carrera;
	}

	public Integer getCodigoAlumno(){
		return codigoAlumno.get();
	}

	public void setCodigoAlumno(Integer codigoAlumno){
		this.codigoAlumno = new SimpleIntegerProperty(codigoAlumno);
	}

	public String getNombre(){
		return nombre.get();
	}

	public void setNombre(String nombre){
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getApellido(){
		return apellido.get();
	}

	public void setApellido(String apellido){
		this.apellido = new SimpleStringProperty(apellido);
	}

	public Integer getEdad(){
		return edad.get();
	}

	public void setEdad(Integer edad){
		this.edad = new SimpleIntegerProperty(edad);
	}

	public String getGenero(){
		return genero.get();
	}

	public void setGenero(String genero){
		this.genero = new SimpleStringProperty(genero);
	}

	public Date getFechaIngreso(){
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso){
		this.fechaIngreso = fechaIngreso;
	}

	public CentroEstudio getCentroEstudio(){
		return centroEstudio;
	}

	public void setCentroEstudio(CentroEstudio centroEstudio){
		this.centroEstudio = centroEstudio;
	}

	public Carrera getCarrera(){
		return carrera;
	}

	public void setCarrera(Carrera carrera){
		this.carrera = carrera;
	}

	public IntegerProperty codigoAlumnoProperty(){
		return codigoAlumno;
	}

	public StringProperty nombreProperty(){
		return nombre;
	}

	public StringProperty apellidoProperty(){
		return apellido;
	}

	public IntegerProperty edadProperty(){
		return edad;
	}

	public StringProperty generoProperty(){
		return genero;
	}
	
	public void guardarRegistro(){
		
	}
	
	public void actualizarRegistro(){
		
	}
	
	public void eliminarRegistro(){
		
	}
}