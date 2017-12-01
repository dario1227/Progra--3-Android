package connections;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marco Herrera on 26/11/2017.
 */


public class HttpRequest {

    public static String get(String query) {
        try {

            URL url = new URL(query);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            client.disconnect();
            return response.toString();
        } catch (IOException exception) {
            return null;
        }
    }
    public static void post(String query,String json) {
        try {
            URL url = new URL(query);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();

            client.setDoOutput(true);
            client.setRequestProperty("Content-Type", "application/json");
            client.setRequestMethod("POST");

            DataOutputStream wr = new DataOutputStream(client.getOutputStream());
            wr.writeBytes(json);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            client.disconnect();
        }catch(Exception e) {}
    }


}
