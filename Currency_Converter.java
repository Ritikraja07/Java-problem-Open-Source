//*Task 4 Currency Convertor */

import java.util.*;
import java.text.DecimalFormat;

// Define the main class for the currency converter
public class Currency_Converter {
    public static void main(String[] args) {
        // Declare variables for different currencies and create a DecimalFormat object for formatting
        double rupee, USD, pound, code, euro, KWD,BRS;
        DecimalFormat f = new DecimalFormat("##.###");
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input
        
        // Display a menu for currency code selection
        System.out.println("\n Enter the currency code \n1:Rupees\n2:US Dollar\n3:Pound\n4:Euro\n5:Kuwati Dinar\n6:Brazilian Real");
        code = sc.nextInt();  // Read the selected currency code from user input

        // Currency conversion based on the selected code
        if(code == 1) {
             // Conversion from Rupees to other currencies
            System.out.println("Enter amount in rupees:");
            rupee = sc.nextFloat();
            USD = rupee / 82.9900;
            System.out.println("US Dollar :" +f.format(USD));

            pound = rupee / 103.68;
            System.out.println("Pound :" +f.format(pound));

            euro = rupee / 89.14;
            System.out.println("Euro :" +f.format(euro));

            KWD = rupee / 268.75;
            System.out.println("Kuwati Diner :" +f.format(KWD));

            BRS = rupee / 16.39;
            System.out.println("Brazilian Real:" + f.format(BRS))
        }
        else if(code == 2) {
            // Conversion from US Dollars to other currencies
            System.out.println("Enter amount in US Dollar:");
            USD = sc.nextFloat();
            rupee = USD * 82.97;
            System.out.println("Rupees :" +f.format(rupee));

            pound = USD * 0.80;
            System.out.println("Pound :" +f.format(pound));

            euro = USD * 0.93;
            System.out.println("Euro :" +f.format(euro));

            KWD = USD * 0.31;
            System.out.println("Kuwati Diner :" +f.format(KWD));

            BRS = USD * 5.07;
            System.out.println("Brazilian Real:" + f.format(BRS))
        }
        else if(code == 3) {
             // Conversion from Pounds to other currencies
            System.out.println("Enter amount in Pound:");
            pound = sc.nextFloat();
            rupee = pound * 103.59;
            System.out.println("Rupees :" +f.format(rupee));

            USD = pound * 1.25;
            System.out.println("Pound :" +f.format(pound));

            euro = pound * 1.16;
            System.out.println("Euro :" +f.format(euro));

            KWD = pound * 0.39;
            System.out.println("Kuwati Diner :" +f.format(KWD));

            BRS = pound * 6.23;
            System.out.println("Brazilian Real:" + f.format(BRS))
        }
        else if(code == 4) {
            // Conversion from Euros to other currencies
            System.out.println("Enter amount in Euro:");
            euro = sc.nextFloat();
            rupee = euro * 89.11;
            System.out.println("Rupees :" +f.format(rupee));

            pound = euro * 0.86;
            System.out.println("Pound :" +f.format(pound));

            USD = euro * 1.07;
            System.out.println("US Dollar :" +f.format(USD));

            KWD = euro * 0.33;
            System.out.println("Kuwati Diner :" +f.format(KWD));

            BRS = euro * 5.37;
            System.out.println("Brazilian Real:" + f.format(BRS))
        }
        else if(code == 5) {
            // Conversion from Kuwaiti Dinars to other currencies
            System.out.println("Enter amount in Kuwaiti Dinar:");
            KWD = sc.nextFloat();
            rupee = KWD * 268.80;
            System.out.println("Rupees : "+f.format(rupee));
            USD = KWD * 3.24;
            System.out.println("US Dollar : "+f.format(USD));
            pound = KWD * 2.60;
            System.out.println("Pound : "+f.format(pound));
            euro = KWD * 3.02;
            System.out.println("Euro : "+f.format(euro));
            BRS = KWD * 16.41;
            System.out.println("Brazilian Real:" + f.format(BRS))
        }
        else if (code == 6){
            //Conversion from Brazilian Real to other currencies
            System.out.println("Enter amount in Brazilian Real:");
            BRS = sc.nextFloat();
            rupee = BRS * 16.42;
            System.out.println("Rupees : "+f.format(rupee));

            USD = BRS * 0,20;
            System.out.println("US Dollar : "+f.format(USD));

            pound = BRS * 0.16;
            System.out.println("Pound :" +f.format(pound));

            euro = BRS * 0,19;
            System.out.println("Euro : "+f.format(euro));



        }
        else {
            // Invalid currency code input
            System.out.println("Invalid Code!");
        }

        sc.close();

    }
}
