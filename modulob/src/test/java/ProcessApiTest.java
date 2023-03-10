import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class ProcessApiTest {

    @Test
    public void methodTest() {

        // Arrange
        ProcessHandle self = ProcessHandle.current();
        long PID = self.pid();
        ProcessHandle.Info procInfo = self.info();

        Optional<String[]> args = procInfo.arguments();
        Optional<String> cmd =  procInfo.commandLine();
        Optional<Instant> startTime = procInfo.startInstant();
        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();

        // Act

        // Assert

    }

    @Test
    public void ejecutarAplicacionesSistemaOperativo() throws IOException {
        try {
            // Arrange
            ProcessBuilder pb = new ProcessBuilder(
                            "C:/Program Files/Google/Chrome/Application/chrome",
                            "https://www.linkedin.com/in/edwindmendezr/"
            );
            // Act
            pb.start();

            // Assert
        } catch (IOException e) {
            Assert.fail("****** Exception ******");
            System.out.println("Error al abrir Visual Studio Code: " + e.getMessage());
        }
    }


    @Test
    public void procesoparalelo() {
        try {
            // Arrange
            URL resourceUrl = ProcessApiTest.class.getClassLoader().getResource("ejemplo.bat");
            File resourceFile = new File(resourceUrl.toURI());
            Process process = new ProcessBuilder(
                    resourceFile.getAbsolutePath().toString())
                    .start();
            // Assert
        } catch (Exception e) {
            Assert.fail("****** Exception ******");
        }

    }


}
