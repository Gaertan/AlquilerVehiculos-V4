package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
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


public class ControllerVistaPrincipal implements Initializable {

	@FXML
    private Button buttonSalir;
	
	@FXML
    private Button buttonGestionarClientes; 
	
	@FXML
    private Button buttonGestionarVehiculos; 
	
	@FXML
    private Button buttonGestionarAlquileres; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
	@FXML
    void gestionarClientes (ActionEvent event) {
		
	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/iesalandalus/programacion/alquilervehiculos/vista/grafica/vistasfxml/VistaClientes.fxml"));
			Parent raiz = fxmlLoader.load();
			Scene escena = new Scene(raiz);
				
			ControllerVistaClientes controlador = fxmlLoader.getController();
				
			//Creamos el escenario
				
	        Stage nuevoEscenario=new Stage();            
	        nuevoEscenario.initModality(Modality.APPLICATION_MODAL);
	        
	        Image icono = new Image("file:imagenes/coche_alquiler.jpeg"); 
	        nuevoEscenario.getIcons().add(icono); 
			
	        nuevoEscenario.setTitle("Gestión de Clientes");
	            
	        //Establecemos la escena
	            
	        nuevoEscenario.setScene(escena);            
	        nuevoEscenario.show();
	            
	        } catch(Exception e) {
				e.printStackTrace();
			}
	} 
	
	@FXML
    void gestionarVehiculos (ActionEvent event) {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/iesalandalus/programacion/alquilervehiculos/vista/grafica/vistasfxml/VistaVehiculos.fxml"));
			Parent raiz = fxmlLoader.load();
			Scene escena = new Scene(raiz);
				
			ControllerVistaVehiculos controlador = fxmlLoader.getController();
				
			//Creamos el escenario
				
	        Stage nuevoEscenario=new Stage();            
	        nuevoEscenario.initModality(Modality.APPLICATION_MODAL);
	        
	        Image icono = new Image("file:imagenes/coche_alquiler.jpeg"); 
	        nuevoEscenario.getIcons().add(icono); 
			
	        nuevoEscenario.setTitle("Gestión de Vehículos");
	            
	        //Establecemos la escena
	            
	        nuevoEscenario.setScene(escena);            
	        nuevoEscenario.show();
	            
	        } catch(Exception e) {
				e.printStackTrace();
			}
	} 
	
	@FXML
    void gestionarAlquileres (ActionEvent event) {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/iesalandalus/programacion/alquilervehiculos/vista/grafica/vistasfxml/VistaAlquileres.fxml"));
			Parent raiz = fxmlLoader.load();
			Scene escena = new Scene(raiz);
				
			ControllerVistaAlquileres controlador = fxmlLoader.getController();
				
			//Creamos el escenario
				
	        Stage nuevoEscenario=new Stage();            
	        nuevoEscenario.initModality(Modality.APPLICATION_MODAL);
	        
	        Image icono = new Image("file:imagenes/coche_alquiler.jpeg"); 
	        nuevoEscenario.getIcons().add(icono); 
			
	        nuevoEscenario.setTitle("Gestión de Alquileres");
	            
	        //Establecemos la escena
	            
	        nuevoEscenario.setScene(escena);            
	        nuevoEscenario.show();
	            
	        } catch(Exception e) {
				e.printStackTrace();
			}
	} 
	
	@FXML
	public void terminar() {
		
		System.exit(0);
	}
}
