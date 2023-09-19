package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rental {

	private List<Car> carList;
	private List<Car> actualList;
	
	private final static String FILENAME = "src/Vehiculos.dat";
	private final static String SEPARATOR = "@";
	
	public Rental() {
		this.carList = getListOfCars();
		this.actualList = new ArrayList<Car>();
		for(Car c : carList)
			actualList.add(c);
	}
	
	public List<Car> getCarList() {
		return this.carList;
	}
	
	public List<Car> getActualListOfCars(){
		return this.actualList;
	}
	
	public void resetFilters() {
		actualList = new ArrayList<Car>();
		
		for(Car c : getCarList()) {
				actualList.add(c);
		}
	}
	
	public void sortListOfCars(String model){
		actualList = new ArrayList<Car>();
		
		for(Car c : getCarList()) {
			if(c.getType().equals(model))
				actualList.add(c);
		}
		
	}
	
	private ArrayList<Car> getListOfCars() {
		ArrayList<Car> cars = new ArrayList<Car>();
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(FILENAME));

	      //Mientras quede informaci�n
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(SEPARATOR);
	        cars.add(new Car(trozos[0],trozos[1],trozos[2],trozos[3]));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida.");
	    }
	    
	    return cars;
	}
}
