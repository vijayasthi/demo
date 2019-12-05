package demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class newAppTest {
    @Test public void newtestAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
    
    @Test public void newtestContentAppAGreeting() {
        App classUnderTest = new App();
		assertEquals("Hi Hello world.", classUnderTest.getGreeting());
	    	//assertEquals("abc", classUnderTest.getGreeting());
    }
}
