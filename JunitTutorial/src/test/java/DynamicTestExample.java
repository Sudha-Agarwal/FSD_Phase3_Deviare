import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class DynamicTestExample {
	
	@TestFactory
	Collection<DynamicTest> generateDynamicTests(){
		return Arrays.asList(
				DynamicTest.dynamicTest("Test1", ()-> {
					//Test Logic for Test1
					Assertions.assertEquals(2, 1+1);
				}),
				
				DynamicTest.dynamicTest("Test2", ()-> {
					Assertions.assertTrue(5 == 3);
				})
				
				);
	}
}
