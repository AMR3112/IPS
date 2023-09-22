package people;


public class Doctor {

	//Crear doctores
//	st.executeUpdate("create table Doctor("
//			+ "name Varchar(20),"
//			+ "surname Varchar(20),"
//			+ "birthdate Date,"
//			+ "experience INT,"
//			+ "license Varchar(20) unique," -> license son 4 numeros y 4 letras
//			+ "dni Varchar(9) unique);");
	
	private String name;
	private String surname;
	private String birthdate;
	private int experience;
	private String license;
	private String dni;
	
	
	public Doctor(String name, String surname, String birthdate, int experience, String license, String dni) {
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.experience = experience;
		this.license = license;
		this.dni = dni;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public int getExperience() {
		return experience;
	}
	public String getLicense() {
		return license;
	}
	public String getDni() {
		return dni;
	}
	
	
	
}
