package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVistas;

public class MainApp {
	
	/** En el método main se hace uso del patrón factoría abstracta para crear nuestro Modelo - 
	 * Vista - Controlador (MVC). En nuestro caso, se ha modificado el constructor del modelo,
	 * ahora hay que pasarle un parámetro de tipo FactoriaFuenteDatos, que puede ser memoria o
	 * ficheros. Simplemente cambiando este dato del enumerado, FICHEROS ó MEMORIA usaremos la 
	 * lógica del programa de la parte del negocio-ficheros o negocio-memoria. Al igual que con
	 * el modelo  */
	
	public static void main(String[] args) {
		
		try {
			
			FactoriaVistas vistas = FactoriaVistas.GRAFICOS;
			FactoriaFuenteDatos fuenteDatos = FactoriaFuenteDatos.FICHEROS; 

			Modelo modeloCascada = new ModeloCascada(fuenteDatos);

			Controlador controlador = new Controlador(modeloCascada, vistas.crear());
			controlador.comenzar();

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}  
	}
}
