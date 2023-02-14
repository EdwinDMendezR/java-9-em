import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceTest {

    @Test
    public void before() {
        FileReader fr = null;
        try {
            fr = new FileReader("ruta/al/archivo.txt");
            // Código que utiliza el objeto FileReader
        } catch (IOException e) {
            // Manejo de excepciones
            System.out.println("***** IOException e 1 *****");
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // Manejo de excepciones
                    System.out.println("***** IOException e 2 *****");
                }
            }
        }
    }

    @Test
    public void methodTest() {
        try (FileReader fr = new FileReader("ruta/al/archivo.txt")) {
            // Código que utiliza el objeto FileReader
        } catch (IOException e) {
            // Manejo de excepciones
        }
    }

}
