package connections;

import org.json.JSONObject;

import java.io.File;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.activities.MainActivity;


public class Polling implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpRequest request = new HttpRequest();
                request.get(R.string.url + "/messages/messages/search");
                String message = request.getResponse();

                request.get(R.string.url + "/messages/messages/search");

                JSONObject messages = new JSONObject(request.getResponse());

                if(messages.has("sender")){
                    if(messages.get("receiver").equals(MainActivity.myUserName)){

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
                        request.post(R.string.url+ "/messages",message);
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}
