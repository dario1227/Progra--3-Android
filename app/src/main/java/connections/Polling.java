package connections;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

import datos1.tec.org.packettec.R;

/**
 * Created by Marco Herrera on 28/11/2017.
 */

public class Polling implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                String message = HttpRequest.get(R.string.url + "/messages/messages/search");
                JSONObject messages = new JSONObject(HttpRequest.get(R.string.url + "/messages/messages/search"));

                if(messages.has("sender")){
                    if(messages.get("receiver").equals("_____NOMBREUSARIO___")){

                        String sender = (String) messages.get("sender");
                        String body  = "";
                        if(messages.has("body")){
                           body = ( String) messages.get("body");
                        }
                        File file = null;
                    if(messages.has("File")){
                        if(!messages.get("File").equals("")){
                             file = HttpFileDownload.downloadFromUrl((String)messages.get("File"));
                        }
                    }
                        if(messages.has("image")){
                            if(!messages.get("image").equals("")){
                                 file = HttpFileDownload.downloadFromUrl((String)messages.get("image"));
                            }
                        }
                        if(messages.has("Audio")){
                            if(!messages.get("Audio").equals("")){
                                 file = HttpFileDownload.downloadFromUrl((String)messages.get("Audio"));
                            }
                        }
                    }
                    else{
                        HttpRequest.post(R.string.url+ "/messages",message);
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}
