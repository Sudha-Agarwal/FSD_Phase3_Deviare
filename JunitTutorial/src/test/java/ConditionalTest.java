import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {
	
	@Test
	@EnabledOnOs(OS.MAC)
	void testOnMacOs() {
		System.out.println("MAC");
		assertTrue(true);
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testOnWindows() {
		System.out.println("windows");
		assertTrue(false);
	}
	
	@Test
	@DisabledOnJre(JRE.JAVA_8)
	void disabledOnJava8() {
		System.out.println("JAVA 8");
		assertTrue(false);
	}
	
	@Test
	@EnabledOnJre({JRE.JAVA_17, JRE.JAVA_18})
	void disabledOnJava17And18() {
		System.out.println("JAVA 17 or 18");
		assertTrue(false);
	}
	
	@Test
	@EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_17)
	void fromJava8ToJava17() {
		System.out.println("From Java8 to Java17");
		
	}
	
	@Test
	@EnabledIfSystemProperty(named= "java.vm.vendor", matches="Oracle.*")
	void onlyIfVendorName() {
		System.out.println("Should run with Oracle vendor");
		
	}
	
	@Test
	@DisabledIf("java.lang.System.getProperty('os.name').toLowerCase().contains('mac')")
	public void shouldNotRunWithMacOs() {
		System.out.println("Should not run with mac os");
	}
	


}
