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


public class HttpRequest implements AsyncResponse{

    String response;

    public void get(String query) {
        try {

            URL url = new URL(query);

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("GET");

            HttpConnection connection = new HttpConnection();
            connection.delegate = this;
            connection.execute(client);

            client.disconnect();
        } catch (IOException exception) {}
    }
    public void post(String query,String json) {
//        try {
//            URL url = new URL(query);
//            HttpURLConnection client = (HttpURLConnection) url.openConnection();
//
//            client.setDoOutput(true);
//            client.setRequestProperty("Content-Type", "application/json");
//            client.setRequestMethod("POST");
//
//            DataOutputStream wr = new DataOutputStream(client.getOutputStream());
//            wr.writeBytes(json);
//
//            HttpConnection connection = new HttpConnection();
//            connection.delegate = this;
//            connection.execute(client);
//
//            client.disconnect();
//        }catch(Exception e) {}
    try{
        String targetUrl = query + "?json=" + json;
        URL url = new URL(targetUrl);

        HttpURLConnection client = (HttpURLConnection) url.openConnection();
        client.setRequestMethod("POST");

        HttpConnection connection = new HttpConnection();
        connection.delegate = this;
        connection.execute(client);
        client.disconnect();
    }catch(Exception e) {
        System.out.println("Error !!!!!!!!!!!!!!!");
    }

}

    @Override
    public void processFinish(StringBuffer output){
        if(output != null) {
            response = output.toString();
            System.out.println(response);
        }else{
            System.out.println("No se pudo conectar");
        }
    }

    public String getResponse(){
        return this.response;
    }
}
