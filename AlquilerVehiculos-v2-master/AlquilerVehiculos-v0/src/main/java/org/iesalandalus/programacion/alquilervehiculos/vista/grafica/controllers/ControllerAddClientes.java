package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controllers; 

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ControllerAddClientes extends VistaGrafica {

    @FXML
    private Button buttonGuardar;

    @FXML
    private TextField campoNombre;
    
    @FXML
    private TextField campoDni;

    @FXML
    private TextField campoTelefono;

    @FXML
    private Label labelTitulo;
    
    private ObservableList<Cliente> listaClientes;
    
    private Cliente registro;
    
    public void setListado(ObservableList<Cliente> listaClientes)
    {
    	this.listaClientes = listaClientes;
    }

    public void setRegistro(Cliente cliente)
    {
    	this.registro = cliente;
    	
    	if(this.registro!=null)
    	{
    		labelTitulo.setText("Editar cliente");
    		this.campoNombre.setText(this.registro.getNombre());
    		this.campoDni.setText(this.registro.getDni());
    		this.campoTelefono.setText(this.registro.getTelefono());
    	}
    	else
    	{
    		labelTitulo.setText("Añadir Cliente");
    	}
    }
    
    public Cliente getRegistro()
    {
    	return this.registro;
    }
        
    @FXML
    void Guardar(ActionEvent event) 
    {
    	try
    	{
	    	String nombre = this.campoNombre.getText();
	    	String dni = this.campoDni.getText();
	    	String telefono = this.campoTelefono.getText();
	    	
	    	if(this.registro == null) // Añadimos un nuevo Cliente
	    	{
	    		Cliente cliente = new Cliente(nombre, dni, telefono);
		    	
		    	if(this.listaClientes.contains(cliente)==false)
		    	{    		    		
		    		this.aviso("Cliente añadido correctamente", AlertType.CONFIRMATION);
		        	this.registro = cliente;
		        	Stage escenarioActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			    	escenarioActual.close();
		    	}
		    	else
		    	{
		    		this.aviso("El cliente ya existe.", AlertType.ERROR);
		    	}
	    	}
	    	else // Modificamos un cliente ya existente
	    	{
	    		this.registro.setNombre(nombre);
	        	this.registro.setDni(dni); 
	        	this.registro.setTelefono(telefono); 
	        	
	        	this.aviso("Cliente modificado correctamente.", AlertType.CONFIRMATION);
	        	Stage escenarioActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	escenarioActual.close();
	        }	
    	}
    	
    	catch(Exception e){
    		
    		this.aviso(e.getMessage(), AlertType.ERROR);
    	}
    }
    
    private void aviso(String aviso, AlertType tipo){
    	
    	Alert a = new Alert(tipo);
    	a.setTitle("Aviso...");
    	a.setHeaderText(aviso);
    	a.show();
    }
}
