import java.util.Scanner; //Import scanner for user input
import java.util.ArrayList; //Import arrays so that information can be stored within the arrays
import java.util.Arrays;

public class critthinkweek5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) //Initialize the scanner
        {
        	
        	// Create an array with names of every day of the week and a temperatures array that will be linked to the corresponding day
			ArrayList<String> Days = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
			ArrayList<Double> Temperatures = new ArrayList<>(); //This creates an empty array so that new information can be added

			// Allow user to input average for each day
			for (String Day : Days) { //This will limit the user inputs for each variable that is within the array
			    System.out.println("Enter average temperature for " + Day + ": ");
			    Temperatures.add(sc.nextDouble()); }

			// Create while loop for various user inputs such as a day, week, or end
			while (true) {
			    System.out.println("Enter a day or 'week' for weekly average, enter 'end' to end program: ");
			    String input = sc.next();
			    
			// If the user wants to end the program they can type 'end'
			if (input.equals("end")) {
				System.out.println("Thank you for using my program, Goodbye");
				System.exit(0); } //This exits the program
					
			// Allow the user to select a specific day	
			if (Days.contains(input)) {
			    int index = Days.indexOf(input);
			    System.out.println(input + ": " + Temperatures.get(index)); }
			    
			// Allow the user to type 'week' to get data for every day and then the average for the entire week
			else if (input.equals("week")) {
			    double sum = 0; //Math to get the average temperature of the week
			    for (int i = 0; i < 7; i++) {
			        System.out.println(Days.get(i) + ": " + Temperatures.get(i));
			        sum += Temperatures.get(i); }
			     System.out.println("Weekly average: " + sum / 7); }
			    
			// If input from user is invalid it will send this message
			else {
			    System.out.println("Invalid input. Please try again."); }
			    }
			}
		}
    }