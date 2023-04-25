package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerVistaClientes extends VistaGrafica implements Initializable {

	@FXML
    private Button buttonAdd; 
	
	@FXML
    private Button buttonSalir;
	
	@FXML
    private Button buttonEdit; 
	
	@FXML
    private Button buttonDelete; 
	
	@FXML
    private Button buttonBack; 
	
	@FXML
    private TextField campoBuscar;
	
	@FXML
    private TextField campoNombre;
	
	@FXML
    private TextField campoDni;

    @FXML
    private TextField campoTelefono;

    @FXML
    private TableColumn<Cliente,String> colNombre;
    
    @FXML
    private TableColumn<Cliente,String> colDni;

    @FXML
    private TableColumn<Cliente,String> colTelefono;

    @FXML
    private TableView<Cliente> tablaClientes;
    
    private ObservableList<Cliente> listaClientes;
    
    private ObservableList<Cliente> listaClientesVisible;
    
    private Cliente registro;
    
    private String filtro;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	listaClientes = FXCollections.observableArrayList();
    	
    	//listaClientes.addAll(controlador.getClientes());
    	//listaClientes.setAll(controlador.getClientes());
		
		this.colNombre.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nombre"));
		this.colDni.setCellValueFactory(new PropertyValueFactory<Cliente,String>("dni"));
		this.colTelefono.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefono"));
    
		this.tablaClientes.setItems(listaClientes);
	}
	
	@FXML
	void addCliente (ActionEvent event) {
		
		try {
			
			System.out.println("Ejecutar tercera ventana"); 
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/iesalandalus/programacion/alquilervehiculos/vista/grafica/vistasfxml/VistaAddClientes.fxml")); 
			   Parent root = loader.load(); 
			   Scene scene2 = new Scene(root);
			   ControllerAddClientes controlador = loader.getController();  
			   
			  
			   Stage stage2 = new Stage(); 
			   stage2.initModality(Modality.APPLICATION_MODAL);
			   
			   stage2.setTitle("añadir cliente");
			   System.out.println("Ejecutar tercera ventana"); 
			   stage2.setScene(scene2);stage2.show();
			   stage2.toFront();  
			
		} catch (IOException e) {
			
			e.getMessage(); 
		} 
	} 
	
	@FXML
    void Buscar(KeyEvent event) 
    {
    	this.filtro = this.campoBuscar.getText();
    	this.refrescarTabla();
    }
	
	@FXML
	void editCliente (ActionEvent event) {
		
		if(this.registro == null) {
			
    		this.aviso("No has seleccionado a ningún cliente", AlertType.ERROR);
    		
    	}else{
    		
    		try{
    			
	    		String nombre = this.campoNombre.getText();
	        	String dni = this.campoDni.getText();
	        	String telefono = this.campoTelefono.getText();
	        	 
	        	this.registro.setNombre(nombre);
	        	this.registro.setDni(dni);
	        	this.registro.setTelefono(telefono);
	        	     	
	        	this.tablaClientes.refresh();
	        	
	        	this.resetFormulario();
	        	
	        	this.aviso("Cliente modificado correctamente.", AlertType.CONFIRMATION);
	        	
    		}catch(Exception e){
    			
    			this.aviso(e.getMessage(), AlertType.ERROR);
    		}
    	}
	} 
	
	@FXML
	void ordenar (ActionEvent event) {
		
		
	}
	
	@FXML
	void deleteCliente (ActionEvent event) {
		
		if(this.registro == null){
			
    		this.aviso("No has seleccionado ningún cliente.", AlertType.ERROR);
    	}
		
    	else{
    		
    		this.listaClientes.remove(this.registro);
    		this.resetFormulario();
    		this.aviso("Cliente eliminado correctamente.", AlertType.CONFIRMATION);
    		        	
    		this.tablaClientes.refresh();
    	}
	} 
	
	private void resetFormulario(){
		
    	this.campoNombre.setText("");
		this.campoDni.setText("");
		this.campoTelefono.setText("");
		
		this.registro = null;
		this.tablaClientes.getSelectionModel().select(null);
    }
	
	@FXML
    void seleccionar(MouseEvent event) 
    {
    	this.registro = this.tablaClientes.getSelectionModel().getSelectedItem();
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
	
	private void refrescarTabla()
    {
    	this.registro = null;
    	this.tablaClientes.getSelectionModel().select(null);
    	
    	this.listaClientesVisible.clear();
    	
    	for(Cliente cliente:this.listaClientes)
    	{
    		if(this.filtro.isEmpty() || cliente.getNombre().toLowerCase().contains(filtro.toLowerCase()))
    		{
    			this.listaClientesVisible.add(cliente);
    		}
    	}
    	    	
    	this.tablaClientes.refresh();
    }
}
