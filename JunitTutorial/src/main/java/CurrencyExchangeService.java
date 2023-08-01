import java.util.HashMap;
import java.util.Map;

public class CurrencyExchangeService {
	private Map<String, Double> exchangeRates;
	
	public CurrencyExchangeService() {
		//initialize the exchange rate map with some sample rates
		
		exchangeRates = new HashMap<>();
		exchangeRates.put("USD_TO_EUR", 0.85);
		exchangeRates.put("USD_TO_GBP", 0.72);
		exchangeRates.put("EUR_TO_GBP", 0.85/0.72);
				
	}
	
	public double getExchangeRate(String currencyPair) {
		return exchangeRates.getOrDefault(currencyPair, 0.0);
	}

}
