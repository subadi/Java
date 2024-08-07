import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONObject;
import javax.json.*;

public class RetrieveData {
    public static void main(String[] args) {
        try {
            // Step 1: Retrieve Data from API
            URL url = new URL("http://example.com/api/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // google gson to serialzie object
            Gson gson = new Gson();
            String json = gson.toJson(listaDePontos); // ArrayList<Ponto> listaDePontos;

           //jackson library to deseailze object
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString( serializableObject );


            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // Step 2: Convert String to JSONArray
            JSONArray users = new JSONArray(content.toString());
            // or JSON Object
            // JSONObject json = new JSONObject(content.toString());

            // Step 3: Modify Data
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                user.put("status", "active");
            }

            // Step 4: Send Updated Data Back
            URL postUrl = new URL("http://example.com/api/users/update");
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
