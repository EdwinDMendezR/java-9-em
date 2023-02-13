import org.junit.Test;

public class AssertTest {

    @Test
    public void palabraReservadaAssert() {

        // Arrange
        int x = 10;
        x = 0;
        // Act

        // Assert
        assert x > 0 : "x debe ser mayor que 0";

    }

}
