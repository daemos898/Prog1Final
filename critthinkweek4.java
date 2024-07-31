import java.util.Scanner; //Import scanner to get user input

public class critthinkweek4 {

	public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) //Initialize scanner
			{
			
			double Total = 0, Max = Double.MIN_VALUE, Min = Double.MAX_VALUE, Value;
			int Count = 0;

			while (Count < 5) { //This will make it so that the loop ends after the 5 entries the user needs to enter
			    System.out.println("Enter a number:");
			    Value = sc.nextDouble();
			    Total += Value;
			    if (Value > Max) Max = Value;
			    if (Value < Min) Min = Value;
			    Count++;
			}

			double Average = Total / 5; //Math to get the average and interest of the user input
			double Interest = Total * 0.2;

			System.out.println("Total is: " + Total); //Print out all of the information for the user to see
			System.out.println("Average is: " + Average);
			System.out.println("Maximum is: " + Max);
			System.out.println("Minimum is: " + Min);
			System.out.println("20% of the Total is: " + Interest);
		}
	}
}