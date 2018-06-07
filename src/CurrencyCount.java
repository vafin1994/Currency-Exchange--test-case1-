
import java.util.Scanner;


public class CurrencyCount {
	public static void main(String[] args) {
		for(int i = 0; ; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Insert currency name (UAH, EUR or GBP)");
			String currencyName = scan.nextLine();
			currencyName = currencyName.toUpperCase();
			
			
			if (currencyName.equals("UAH") || currencyName.equals("GBP") || currencyName.equals("EUR")){
				System.out.println("Insert price");
				double price = scan.nextDouble();
				
				if(price <= 0) {
					System.out.println("Price should be more than 0");
				}else {
					System.out.println("");
					getApi ob = new getApi(currencyName);
					Exchange test1 = new Exchange(price, currencyName);
					double finalPrice = test1.count(price, currencyName);
					finalPrice = (double)Math.round(finalPrice * 100d) / 100d;
					System.out.println("Price in " + currencyName + " is " + finalPrice);
					//break;
					//In case that you want only one successful implemintation of programm, just uncomment previous string
				}
				
			}else {
				if(i == 5) {System.out.println("You made 5 attempts, but still did not enter the name of the currency or price correctly, please close the program and try again later");
				}else {
				System.out.println("Invalid name of currency, insert GBP, EUR or UAH" );
				}
			}
		}
		
	}

}
