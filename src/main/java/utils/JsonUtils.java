package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Get test data from JSON file by testcaseId
     *
     * @param fileName   JSON file name without extension (e.g., "TestLoginData")
     * @param testcaseId Test case ID to fetch (e.g., "001")
     * @return JsonNode of the matching test case, or null if not found
     */
    public static JsonNode getTestData(String fileName, String testcaseId) {
        try {
            // Path to JSON test data
            File file = new File("src/test/resources/testdata/" + fileName + ".json");

            // Read root array from file
            JsonNode rootArray = mapper.readTree(file);

            // Loop through array and return node with matching testcaseId
            for (JsonNode node : rootArray) {
                if (node.has("testcaseId") && node.get("testcaseId").asText().equals(testcaseId)) {
                    return node;
                }
            }

            // If not found
            System.out.println("Test data not found for testcaseId: " + testcaseId);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}