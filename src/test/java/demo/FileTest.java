package demo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.nio.file.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.io.FileMatchers.*;

public class FileTest {
    @Test public void testFileisCreated() {
        //File file = new File("C:/Users/vasthi/Desktop/hi.txt");
        //assertTrue(file.exists());
        //assertTrue(Paths.get("C:/Users/vasthi/Desktop/hi.txt").toFile().exists());
        //Path p = Paths.get("C:/Users/vasthi/Desktop/hi.txt");
        //assertTrue(Files.exists(p));
        /////assertTrue(File.exists(Paths.get("C:/Users/vasthi/Desktop/hi.txt")));
        
        //if(Files.exists(Paths.get("C:/Users/vasthi/Desktop/hi.txt"))) { 
          //  assertTrue;
          //  }
        


//Path path = Paths.get("C:/Users/vasthi/Desktop/h1i.txt");

//if (Files.exists(path)) {
 // System.out.println("File exists!");
//}
        
        
    File file = new File("C:/Users/vasthi/Desktop/hi.txt");
     
    assertThat(file, anExistingFile());
    assertThat(file, anExistingFileOrDirectory());        
    }
}
