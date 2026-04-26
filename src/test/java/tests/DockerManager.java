package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DockerManager {

    @BeforeSuite
    public void runDockerCommandBatchFile() throws IOException, InterruptedException {
        String projectPath = System.getProperty("user.dir");
        String batFilePath = projectPath + File.separator + "DockerFile" + File.separator + "dockerUp.bat";

        Runtime.getRuntime().exec("cmd /c start " + batFilePath);


        // ✅ Wait for Grid using logs
        File logFile = new File(projectPath + File.separator + "DockerFile" + File.separator + "output.txt");

        long startTime = System.currentTimeMillis();
        long timeout = 120000; // 2 minutes

        boolean hubStarted = false;
        boolean nodeAdded = false;

        while (System.currentTimeMillis() - startTime < timeout) {

            if (logFile.exists()) {

                BufferedReader reader = new BufferedReader(new FileReader(logFile));
                String line;

                while ((line = reader.readLine()) != null) {

                    if (line.contains("Started Selenium Hub")) {
                        hubStarted = true;
                    }

                    if (line.contains("Node has been added")) {
                        nodeAdded = true;
                    }

                    if (hubStarted && nodeAdded) {
                        System.out.println("✅ Grid is READY!");
                        reader.close();
                        return;
                    }
                }

                reader.close();
            }
            System.out.println("⏳ Waiting for Grid to be ready...");
            Thread.sleep(2000);
        }
        throw new RuntimeException("❌ Grid not started within timeout!");
    }

    @AfterSuite
    public void stopDockerTest() throws IOException, InterruptedException {
        String projectPath = System.getProperty("user.dir");
        String batFilePath = projectPath + File.separator + "DockerFile" + File.separator + "dockerDown.bat";

        Runtime.getRuntime().exec("cmd /c start " + batFilePath);
        Thread.sleep(10000);
        // ✅ Delete output.txt after execution
        File logFile = new File(projectPath + File.separator + "DockerFile" + File.separator + "output.txt");

        if (logFile.exists()) {
            boolean deleted = logFile.delete();
            if (deleted) {
                System.out.println("🧹 output.txt deleted successfully");
            } else {
                System.out.println("⚠️ Failed to delete output.txt");
            }
        } else {
            System.out.println("ℹ️ output.txt not found");
        }
    }
}
