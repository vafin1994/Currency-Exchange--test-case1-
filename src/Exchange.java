
class Exchange {
	double USAprice;
	String currency;
	double price = 0;
	static double rate = 0;
	
	Exchange(double p, String c){
		USAprice = p;
		currency = c;
	}
	
	double count(double p, String c) {
		getApi ob = new getApi(currency);
		double localPrice = USAprice * rate;
		return localPrice;
		
	}
}
