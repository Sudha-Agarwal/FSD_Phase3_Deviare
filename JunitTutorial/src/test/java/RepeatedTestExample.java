import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

public class RepeatedTestExample {
	/*@RepeatedTest(value=5, name= "Repetition {currentRepetition} of {totalRepetitions}")
	void testRepeatedAddition(RepetitionInfo repetitionInfo) {
		int result = 2 + 3;		
		assertEquals(5, result);		
		System.out.println("Current Repetition: " + repetitionInfo.getCurrentRepetition());
	}
	*/
	@RepeatedTest(10)
	void testRepeated(TestReporter testReporter) {
		int randomNumber = (int)(Math.random() * 100);
		testReporter.publishEntry("Random Number: " + String.valueOf(randomNumber));
		
	}
	

}
