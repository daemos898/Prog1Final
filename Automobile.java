//The purpose of this is to create the class of automobile so that all of the variables have been declared for the actual program to call upon and use

class Automobile {
	
	//Declare variables
	private String make;
	private String model; 
	private String color;
	private int year; 
	private int mileage;
	
	//Create constructor to connect the vehicle variables together
	public Automobile(String make, String model, String color, int year, int mileage) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
	
	//This is to get the declared variables
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	//This is to set the declared variables
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
}
