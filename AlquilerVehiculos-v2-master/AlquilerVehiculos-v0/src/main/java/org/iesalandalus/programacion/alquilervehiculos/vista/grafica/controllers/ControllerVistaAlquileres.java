package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerVistaAlquileres extends VistaGrafica implements Initializable {
    
	@FXML
    private Button buttonAdd; 
	
	@FXML
    private Button buttonSalir;
	
	@FXML
    private Button buttonEdit; 
	
	@FXML
    private Button buttonDelete; 
	
	@FXML
    private TableColumn<Alquiler,Cliente> colCliente; 
    
    @FXML
    private TableColumn<Alquiler,Vehiculo> colVehiculo;

    @FXML
    private TableColumn<Alquiler,LocalDate> colFechaAlquiler;
    
    @FXML
    private TableColumn<Alquiler,LocalDate> colFechaDevolucion;
    
    @FXML
    private TableView<Alquiler> tablaAlquileres;
    
    private ObservableList<Alquiler> listaAlquileres;
    
    private Alquiler registro;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	listaAlquileres = FXCollections.observableArrayList();
    	
    	//listaClientes.addAll(controlador.getClientes());
    	//listaClientes.setAll(controlador.getClientes());
		
		this.colCliente.setCellValueFactory(new PropertyValueFactory<Alquiler,Cliente>("cliente"));
		this.colVehiculo.setCellValueFactory(new PropertyValueFactory<Alquiler,Vehiculo>("vehiculo"));
		this.colFechaAlquiler.setCellValueFactory(new PropertyValueFactory<Alquiler,LocalDate>("fecha alquiler"));
		this.colFechaDevolucion.setCellValueFactory(new PropertyValueFactory<Alquiler,LocalDate>("fecha devolucion"));
		
		this.tablaAlquileres.setItems(listaAlquileres);
	}
	
	@FXML
	void addAlquiler (ActionEvent event) {
		
		try {
			
			System.out.println("Ejecutar tercera ventana"); 
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/iesalandalus/programacion/alquilervehiculos/vista/grafica/vistasfxml/VistaAddClientes.fxml")); 
			System.out.println("Ejecutar cuarta ventana"); 
			Parent root = loader.load(); 
			
			System.out.println("Ejecutar cuarta ventana"); 
			
			// ControllerAddVehiculo controlador = loader.getController();  
			
			Scene scene = new Scene(root);
			Stage stage = new Stage(); 
			
			stage.setScene(scene); 
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.toFront(); 
			stage.showAndWait();
			
			System.out.println("Ejecutar cuarta ventana"); 
			
		} catch (IOException e) {
			
			e.getMessage(); 
		} 
	} 
	
	@FXML
	void deleteAlquiler (ActionEvent event) {
		
		if(this.registro == null){
			
    		this.aviso("No has seleccionado ningún alquiler.", AlertType.ERROR);
    	}
		
    	else{
    		
    		this.listaAlquileres.remove(this.registro);
    		this.resetFormulario();
    		this.aviso("Alquiler eliminado correctamente.", AlertType.CONFIRMATION);
    		        	
    		this.tablaAlquileres.refresh();
    	}
	} 
	
	private void resetFormulario(){
		
    	/*  this.campoMarca.setText("");
		this.campoModelo.setText("");
		this.campoMatricula.setText("");
		this.campoCilindrada.setText("");
		this.campoNumPlazas.setText("");
		this.campoPma.setText("");
		
		this.registro = null;
		this.tablaVehiculos.getSelectionModel().select(null);   */
    }  
	
	@FXML
	void seleccionar(ActionEvent event) {
		
		this.registro = this.tablaAlquileres.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	void ordenar (ActionEvent event) {
		
		
	}
	
	@FXML
	
	void volver(ActionEvent event) {
		
		Stage escenarioActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	escenarioActual.close();
	}
	
	private void aviso(String aviso, AlertType tipo){
		
    	Alert alert = new Alert(tipo);
    	alert.setTitle("Aviso...");
    	alert.setHeaderText(aviso);
    	alert.show();
    }
	
	@FXML
	public void terminar() {
		
		System.exit(0);
	}
}
