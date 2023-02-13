import org.junit.Assert;
import org.junit.Test;

public class MetodosInterfaceTest {


    interface Animal {
        String getSound();

        default String getName() {
            return "Animal";
        }

    }

    class Dog implements Animal {

        @Override
        public String getSound() {
            return "DOG::Sound";
        }

    }

    @Test
    public void methodTest() {

        // Arrange
        Dog dog = new Dog();

        // Act
        String sound = dog.getSound();
        String name = dog.getName();

        // Assert
        Assert.assertEquals("DOG::Sound", sound);
        Assert.assertEquals("Animal", name);

    }

}
