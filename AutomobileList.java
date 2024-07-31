import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AutomobileList {
	
	//This will store the information that the user enters
	private ArrayList<Automobile> vehicles;
	
	//Create the scanner for user input
	public static Scanner obj = new Scanner(System.in);

	//Constructor to add new vehicles to the array
	public AutomobileList() {
		//Create an empty array for new vehicles to start being added
		vehicles = new ArrayList<Automobile>();
	}
	
	//This method has been added for a user to add a new vehicle
	public boolean addNewVehicle() {
		
		//User will input the following vehicle information
		try {
			
			//The try statement will make sure that strings are not being added to integers
			System.out.print("\nEnter vehicle make: ");
			String make = obj.nextLine();
			
			//Both model and ID number will help differentiate between two identical vehicles
			System.out.print("\nEnter vehicle model and unique ID Number: ");
			String model = obj.nextLine();
			
			System.out.print("\nEnter vehicle color: ");
			String color = obj.nextLine();
			
			System.out.print("\nEnter vehicle year: ");
			int year = Integer.parseInt(obj.nextLine());
			
			System.out.print("\nEnter vehicle mileage: ");
			int mileage = Integer.parseInt(obj.nextLine());
			
			//This will create the new entry in the arrow in the order that the user input the information for each variable
			this.vehicles.add(new Automobile(make, model, color, year, mileage));
			System.out.print("\nVehicle has been added to inventory\n");
			return true;
			
		} catch (Exception e) {
			//If something that was invalid was caught it will provide the user this message
			System.out.print("\nInvalid input has been provided. Vehicle could not be added to inventory.\n");
			
			return false;
		}
	}
	
	//This method will allow a user to remove a vehicle
		public boolean removeVehicle() {
			
			try {
				//User must enter Model and unique ID number to remove vehicle
				System.out.print("\nPlease enter Model and unique ID number to remove a vehicle\n: ");
				String model = obj.nextLine();
				
				boolean isFound = false;
				
				//Search for vehicle that matches user input
				for (Automobile vehicle : this.vehicles) {
					
					if (vehicle.getModel().equals(model)) {
						
						isFound = true;
						
						//Vehicle will be removed from array if there is a match found
						this.vehicles.remove(vehicle);
						System.out.print("\nVehicle has been successfully removed\n");
						return true;
					}
					
				}
				
				//Will alert user that the vehicle was not found if there was no match
				if (!isFound) {
					System.out.print("\nVehicle could not be found\n");
					return false;
				} else {
					return true;
				}
				//Being the model and id are a string then if a user provides an integer this will catch it
			} catch (Exception e) {
		      System.out.print("\nUnexpected user entry, please try again.\n");
				
				return false;
			}
		}
	
	//This is so a user can update an existing vehicle in-case they entered the wrong information
	public boolean updateVehicle() {

		try {
			//Have user enter model and ID number
			System.out.print("\nPlease enter model and unique ID number to update the vehicle: \n");
			String model = obj.nextLine();
			
			boolean isFound = false;
			
			for (Automobile vehicle : this.vehicles) {
				
				if (vehicle.getModel().equals(model)) {
					
					//If a vehicle was found that matches user input prompt user to input new information for that vehicle
					isFound = true;
					
					System.out.print("\nEnter new vehicle make: ");
					String make = obj.nextLine();
					vehicle.setMake(make);
					
					System.out.print("\nEnter new vehicle model and unique ID number: ");
					String newModel = obj.nextLine();
					vehicle.setModel(newModel);
					
					System.out.print("\nEnter new vehicle color: ");
					String color = obj.nextLine();
					vehicle.setColor(color);
					
					System.out.print("\nEnter new vehicle year: ");
					int year = Integer.parseInt(obj.nextLine());
					vehicle.setYear(year);
					
					System.out.print("\nEnter vehicle mileage: ");
					int mileage = Integer.parseInt(obj.nextLine());
					vehicle.setMileage(mileage);
					
					System.out.print("\nVehicle information has been successfully updated\n");
					return true;
				}
				
			}
			
			//This is a message for the user if there is not a matching vehicle in the list
			if (!isFound) {

				System.out.print("\nThere was not a vehicle that matches the information provided.\n");
				return false;
			} else {
				return true;
			}
			
		//Much like the other catches this is if there is invalid input from the user	
		} catch (Exception e) {
	      System.out.print("\nUnexpected user entry, please try again.\n");
			
			return false;
		}
	
	}
	
	//This will allow a user to see the entire list of vehicles that have been added which they can reference when creating, deleting, and changing vehicles
	public void displayVehicleList() {
		
		//Alert the user that the inventory is being shown and create the list going downwards with the information being grouped together
		System.out.print("\n\nThese are the vehicles currently in your inventory: \n");
		
		System.out.printf("\n%15s %15s %15s %15s %15s", "Make", "Model" , "Color", "Year", "Mileage");
		
		for (Automobile vehicle : this.vehicles) {
			System.out.printf("\n%15s %15s %15s %15d %15d", vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage());
		}
		
	}
	
	//This will allow the user to save and print the list of all vehicles that are in the array
	public void writeToFile(String filePath) {
		try {
		      
			FileWriter myWriter = new FileWriter(filePath);
		      
		      myWriter.write(String.format("%15s %15s %15s %15s %15s\n\n", "Make", "Model" , "Color", "Year", "Mileage"));
		      
		      for (Automobile vehicle : this.vehicles) {

			      myWriter.write(String.format("%15s %15s %15s %15d %15d\n", vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage()));
		      }
		      
		      myWriter.close();
		      
		      //This is the catch allowing the user to know that the write function was successful or not
		      System.out.println("Successfully saved the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred while saving the file.");
		      e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {

		//We must create the menu that the user can use to select what they want to do
		AutomobileList ourInventory = new AutomobileList();
		
		boolean cont = true;
		int userChoice;
		
		//A while loop will let the user keep making changes until they decide to exit
		while (cont) {
			
			//This displays all the options the user has
			System.out.print("\nMenu: \n1. Add new vehicle \n2. Remove a vehicle \n3. Update a vehicle \n4. List all vehicles \n5. Exit and save to file \n\nEnter your choice: ");
			
			userChoice = Integer.parseInt(obj.nextLine());
			
			switch (userChoice) {
			
			case 1:
				ourInventory.addNewVehicle();
				break;
				
			case 2:
				ourInventory.removeVehicle();
				break;
				
			case 3:
				ourInventory.updateVehicle();
				break;
				
			case 4:
				ourInventory.displayVehicleList();
				break;
				
			case 5:
				
				System.out.print("\nDo you wish to print the inventory list? (Y or N) : ");
				String isWrite = obj.nextLine();
				
				if (isWrite.equals("Y")) {

					System.out.print("\nEnter file path: ");
					String path = obj.nextLine();
					ourInventory.writeToFile(path);
				}
				
				cont = false;
				
				System.out.print("\nYou Successfuly exited the program");
				break;
				
			default: 
				System.out.print("\nPlease choose an option from the menu\n");
				break;
			
			}
			
			
		}


	}

}