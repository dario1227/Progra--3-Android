package datos1.tec.org.packettec.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WriteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button;
    private ImageButton backButton;
    private EditText messageText;


    public WriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WriteFragment newInstance(String param1, String param2) {
        WriteFragment fragment = new WriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_write, container, false);

        button = v.findViewById(R.id.attachBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backButton = v.findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                if (manager.getBackStackEntryCount() > 0) {
                    manager.popBackStackImmediate();
                }
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final MainActivity mainActivity = (MainActivity) getActivity();
        messageText = mainActivity.findViewById(R.id.MessageText);
        messageText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    try {
                        JSONObject message = new JSONObject();
                        message.put("receiver", "Contact");//mainActivity.findViewById(R.id.contactText)); //Guardar el destinatario en una variable
                        message.put("body", messageText.getText().toString());
                        message.put("sender", "Jasson");//MainActivity.myUserName);
                        StringRequest sendMessage = new StringRequest(Request.Method.POST, getString(R.string.url) + "messages?json=" + message.toString(),
                                new Response.Listener<String>() {

                                    @Override
                                    public void onResponse(String response) {
                                        messageText.getText().clear();
                                        System.out.println("Mensaje enviado satisfactoriamente");
                                    }
                                }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.println("No se pudo enviar el mensaje: " + error.getMessage().toString());
                            }
                        });
                        MainActivity.requestQueue.add(sendMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }
}
