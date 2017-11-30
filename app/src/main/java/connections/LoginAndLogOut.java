package connections;

/**
 * Created by kenne on 11/29/2017.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
public class LoginAndLogOut {
//    public static void LogIn(String name) {
//        try {
//            String query = "http://localhost:9080/webapi/services/auth" + "?Name=" + name;
//            URL url = new URL(query);
//
//            HttpURLConnection client = (HttpURLConnection) url.openConnection();
//            client.setRequestMethod("POST");
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//            client.disconnect();
//        } catch (IOException exception) {
//        }
//    }
//    public static void LogOut() {
//        try {
//            String query = "http://localhost:9080/webapi/services/auth/logOut";
//            URL url = new URL(query);
//
//            HttpURLConnection client = (HttpURLConnection) url.openConnection();
//            client.setRequestMethod("POST");
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//            client.disconnect();
//        } catch (IOException exception) {
//        }
//    }
}
