package demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileTest {
    @Test public void testFileisCreated() {
        //File file = new File("C:/Users/vasthi/Desktop/hi.txt");
        //assertTrue(file.exists());
        assertTrue(Paths.get("C:/Users/vasthi/Desktop/hi.txt").toFile().exists());
    }
}
