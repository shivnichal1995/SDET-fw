package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DockerStopTest {
    @AfterSuite
    public void stopDockerTest() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String batFilePath = projectPath + File.separator + "DockerFile" + File.separator + "dockerDown.bat";

        Runtime.getRuntime().exec("cmd /c start " + batFilePath);
    }
}
