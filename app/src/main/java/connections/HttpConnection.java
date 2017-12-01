package connections;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Jai on 30/11/17.
 */

public class HttpConnection extends AsyncTask<HttpURLConnection, Integer, StringBuffer> {
    public AsyncResponse delegate = null;

    @Override
    protected StringBuffer doInBackground(HttpURLConnection... client) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client[0].getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response;
        }catch (IOException e){}
        return null;
    }

    @Override
    protected void onPostExecute(StringBuffer result){
        delegate.processFinish(result);
    }
}
