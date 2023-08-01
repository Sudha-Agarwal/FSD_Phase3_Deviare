import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calculator;
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
		System.out.println("Before each test");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After each test");
	}
	
	@Test
	@DisplayName("Test Addition")
	@Tag("math")
	void testAddition() {
		System.out.println("Inside Test case");
		int result = calculator.add(2, 3);
		Assertions.assertEquals(5,result);
	}
	
	@Test
	@Disabled
	@DisplayName("Test Division")
	@Tag("math1")
	void testDivision() {
		System.out.println("Inside Test case");
		int result = calculator.divide(2, 3);
		Assertions.assertEquals(5,result);
	}
	
	@Nested
	class InnerTest1{
		@BeforeEach
		void setUp() {
			System.out.println("setting up InnerTest1");
		}
		
		@AfterEach
		void tearDown() {
			System.out.println("tearing down InnerTest1");
		}
		
		@Test
		void innerTest1() {
			System.out.println("Running InnerTest1");
		}
	}
	
	@BeforeAll
	static void setUpAll() {
		System.out.println("setting up the test environment");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("cleaning up the test environment");
	}

}
