
import java.util.Scanner;


public class CurrencyCount {
	public static void main(String[] args) {
		for(int i = 0; ; i++) {
			Scanner scan = new Scanner(System.in);
			double price = 0;
			System.out.println("Insert currency name (UAH, EUR or GBP)");
			String currencyName = scan.nextLine();
			currencyName = currencyName.toUpperCase();
			
			
			if (currencyName.equals("UAH") || currencyName.equals("GBP") || currencyName.equals("EUR")){
				
				for(int j = 0; ;j++) {
					System.out.println("Insert price");
					try {
						price = scan.nextDouble();
						break;
					}catch(java.util.InputMismatchException e) {
						System.out.println("Exeption " + e);
						System.out.println("Only numbers availible here");
						break;
					}
					
				}
				
				if(price <= 0) {
					System.out.println("Price should be more than 0 and contains only numbers");
				}else {
					System.out.println("");
					getApi ob = new getApi(currencyName);
					Exchange test1 = new Exchange(price, currencyName);
					double finalPrice = test1.count(price, currencyName);
					finalPrice = (double)Math.round(finalPrice * 100d) / 100d;
					System.out.println("Price in " + currencyName + " is " + finalPrice);
					//break;
					//In case that you want only one successful implementation of program, just uncomment previous string
				}
				
			}else {	
				System.out.println("Invalid name of currency, insert GBP, EUR or UAH" );
			}
		}
		
	}

}
