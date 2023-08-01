import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest {
	
	@org.junit.jupiter.params.ParameterizedTest
	@ValueSource(ints = {1,2,3,4,-5})
	void testIsPositive(int number) {
		assertTrue(number > 0, ()-> number + " should be positive");
	}
	

}
