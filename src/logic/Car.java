package logic;

public class Car {

	private String type;
	private String description;
	private String model;
	private String price;
	
	public Car(String t, String m, String d, String p) {
		this.type = t;
		this.model = m;
		this.description = d;
		this.price = p;
	}

	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getModel() {
		return model;
	}
	public String getPrice() {
		return price;
	}
	
	
}
