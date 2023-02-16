package variable.handles;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Repeat;

public class VariableHandlesTest {

    @Test
    @Repeat(100)
    public void methodTest() {
        ConcurrentClass concurrentClass = new ConcurrentClass();
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentClass.incrementarContador();
            }
        });
        Thread hilo2= new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentClass.incrementarContador();
            }
        });
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("*********************************");
        }
        Assert.assertEquals(2000, concurrentClass.getContador());
    }

}
