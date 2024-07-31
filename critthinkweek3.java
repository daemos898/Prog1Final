import java.util.Scanner;

public class critthinkweek3 {

	public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			double WeeklyIncome;
			double TaxRate, TotalTax;
			System.out.println("Enter your weekly income: ");
			WeeklyIncome = sc.nextDouble();

			
			if (WeeklyIncome < 500) 
			{
			    TaxRate = 0.1;
			} 
			else if (WeeklyIncome >= 500 && WeeklyIncome < 1500)
			{
			    TaxRate = 0.15;
			} 
			else if (WeeklyIncome >= 1500 && WeeklyIncome < 2500) 
			{
			    TaxRate = 0.2;
			} 
			else 
			{
			    TaxRate = 0.3;
			}

			TotalTax = WeeklyIncome * TaxRate;
		

        System.out.println("Your weekly average tax withholding is: $" + TotalTax);
        
        }
	}
}