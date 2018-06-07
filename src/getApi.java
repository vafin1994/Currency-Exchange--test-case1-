import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getApi {
	public getApi(String s) {
	
	String currName = s;
	String link = "https://free.currencyconverterapi.com/api/v5/convert?q=USD_" + currName +"&compact=y&callback=sampleCallback";
	
	HttpURLConnection connection = null;
	
	try {
		connection = (HttpURLConnection) new URL(link).openConnection();
		
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setConnectTimeout(2000);
		connection.setReadTimeout(2000);
		
		connection.connect();
		
		StringBuilder sb = new StringBuilder();
		
		if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			
				String currency = sb.toString();
				currency = currency.substring(78);
				currency = currency.substring(0, currency.indexOf('}'));
				Double rate = Double.parseDouble(currency);
				Exchange.rate = rate;
			
		}else {
			System.out.println("Error: " + connection.getResponseCode());
		}
		
	} catch (Throwable cause) {
		cause.printStackTrace();
	}finally {
		if(connection != null) {
			connection.disconnect();
		}
	}
	}
	
}
