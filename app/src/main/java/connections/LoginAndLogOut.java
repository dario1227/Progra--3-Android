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

public class LoginAndLogOut implements AsyncResponse{
    public void LogIn(String address, String name) {
        try {
            String query = address + "auth" + "?Name=" + name;
            URL url = new URL(query);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");

            HttpConnection connection = new HttpConnection();
            connection.delegate = this;
            connection.execute(client);
            client.disconnect();
        } catch (IOException exception) {
        }
    }
    public void LogOut() {
        try {
            String query = "http://localhost:9080/webapi/services/auth/logOut";
            URL url = new URL(query);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");

            HttpConnection connection = new HttpConnection();
            connection.delegate = this;
            connection.execute(client);

            client.disconnect();
        } catch (IOException exception) {
        }
    }

    @Override
    public void processFinish(StringBuffer output){
        System.out.println(output.toString());
    }
}
