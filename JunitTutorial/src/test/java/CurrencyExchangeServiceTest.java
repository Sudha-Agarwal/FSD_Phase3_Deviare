import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class CurrencyExchangeServiceTest {
	
	CurrencyExchangeService currencyExchangeService;
	
	@BeforeEach
	void CurrencyExchangeService(){
		currencyExchangeService = new CurrencyExchangeService();
	}
	
	@TestFactory
	Collection<DynamicTest> testCurrencyExchangeRates(){
		
		Map<String, Double> currencyPairs = new HashMap<>();
		currencyPairs.put("USD_TO_EUR", 0.88);
		currencyPairs.put("USD_TO_GBP", 0.72);
		currencyPairs.put("EUR_TO_GBP", 0.85/0.72);
		
		return currencyPairs.entrySet().stream().map(entry -> DynamicTest.dynamicTest("Test", ()->{
			String currencyPair = entry.getKey();
			double expectedrate = entry.getValue();
			
			double actualRate = currencyExchangeService.getExchangeRate(currencyPair);
			
			Assertions.assertEquals(expectedrate, actualRate);
		})).toList();		
	}

}
