package connections;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import datos1.tec.org.packettec.activities.MainActivity;
import datos1.tec.org.packettec.fragments.ConvoFragment;


public class Polling implements Runnable {
    private boolean running = true;

    @Override
    public void run() {
        JsonObjectRequest getMessages = null;
        getMessages = new JsonObjectRequest(Request.Method.GET, MainActivity.URL + "messages", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject messages) {
                        //En caso de ok
                        if (messages.has("sender")) {
                            try {
                                if (messages.get("receiver").equals(MainActivity.myUserName)) {

                                    String sender = (String) messages.get("sender");
                                    String body = "";
                                    if (messages.has("body")) {
                                        body = (String) messages.get("body");
                                    }
                                    System.out.println(body);
                                    ConvoFragment.addConversation(sender, body);

                                } else {
                                    StringRequest sendMessage = new StringRequest(Request.Method.POST, MainActivity.URL + "messages?json=" + messages.toString(),
                                            new Response.Listener<String>() {

                                                @Override
                                                public void onResponse(String response) {
                                                    System.out.println("Mensaje enviado satisfactoriamente");
                                                }
                                            }, new Response.ErrorListener() {

                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            System.out.println("No se pudo enviar el mensaje: " + error.getMessage().toString());
                                        }
                                    });
                                    MainActivity.requestQueue.add(sendMessage);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //En caso de error
                    }
                });

        while (running) {
            try {
                Thread.sleep(2000);
                MainActivity.requestQueue.add(getMessages);
            } catch (Exception e) {
            }
        }
    }
}
