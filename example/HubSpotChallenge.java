import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONObject;
import javax.json.*;

public class HubSpotChallenge {
    public static void main(String[] args) {
        try {
            // Step 1: Retrieve Data from API
            URL url = new URL("https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=0395f54bbe421c4942884c307b48");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println("Test data is:"+content);
            in.close();
            conn.disconnect();

            // Step 2: Convert String to JSONArray
            JSONArray c = new JSONArray(content.toString());

            // Step 3: Modify Data
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                user.put("status", "active");
            }

            // Step 4: Send Updated Data Back
            URL postUrl = new URL("https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=0395f54bbe421c4942884c307b48");
            HttpURLConnection postConn = (HttpURLConnection) postUrl.openConnection();
            postConn.setRequestMethod("POST");
            postConn.setDoOutput(true);
            postConn.setRequestProperty("Content-Type", "application/json");
            postConn.getOutputStream().write(users.toString().getBytes());

            int responseCode = postConn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Failed to update data.");
            }
            postConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
