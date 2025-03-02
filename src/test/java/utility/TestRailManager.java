package utility;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {

    public static String TEST_RUN_ID = "1";
    public static String testRailUserName = ConfigReader.getProperty("testRailEmail");
    public static String testRailPassword = ConfigReader.getProperty("testRailPassword");
    public static String testRailEngineUrl = ConfigReader.getProperty("testRailEngineUrl");

    public static int testCasePassStatus = 1;
    public static int testCaseFailStatus = 5;

    public static void addResultsForTestCase(String testCaseId, String error, int status) {
        String testRunId = TEST_RUN_ID;
        APIClient client = new APIClient(testRailEngineUrl);
        client.setUser(testRailUserName);
        client.setPassword(testRailPassword);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", status);
        data.put("comment", error);
        try {
            JSONObject response = (JSONObject) client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId, data);
            Long resultIdLong = (Long) response.get("id");
            int resultId = resultIdLong.intValue();

            if(status == testCaseFailStatus){
                File screenshotFile = ScreenshotSendEmail.takeScreenshot();
                client.sendPost("add_attachment_to_result/" + resultId, screenshotFile.getAbsolutePath());
                System.out.println("Ekran görüntüsü ilgili test case'e eklendi!");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
}
