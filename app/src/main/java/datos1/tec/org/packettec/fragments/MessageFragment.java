package datos1.tec.org.packettec.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.adapters.MessagesAdaptor;
import datos1.tec.org.packettec.model.Messages;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    MessagesAdaptor adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String body;
    private String sender;

    public MessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
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
            String body = "New Message";
            String sender = "Marco";

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_message, container, false);

        recyclerView = v.findViewById(R.id.recycler_messages);
        System.out.println(recyclerView);

        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(20));

        recyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MessagesAdaptor();
        populateRecyclerViewValuesMessages();


        return v;

    }

//    public void populateRecyclerViewValues(String sender, String body) {
//
//        ArrayList<Messages> listContentArr = new ArrayList<>();
//
//        //Creating POJO class object
//        Messages messages = new Messages();
//        //Values are binded using set method of the POJO class
//        messages.setUserName(sender);
//        messages.setContent(body);
//        //After setting the values, we add all the Objects to the array
//        //Hence, listConentArr is a collection of Array of POJO objects
//
//        listContentArr.add(messages);
//
//        //We set the array to the adapter
//        adapter.setListContent(listContentArr);
//        //We in turn set the adapter to the RecyclerView
//        recyclerView.setAdapter(adapter);
//    }


    public void populateRecyclerViewValuesMessages() {

        ArrayList<Messages> listContentArr = new ArrayList<>();
        /** This is where we pass the data to the adpater using POJO class.
         *  The for loop here is optional. I've just populated same data for 50 times.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for (int iter = 0; iter <= 10; iter++) {
            //Creating POJO class object
            Messages pojoObject = new Messages();
            //Values are binded using set method of the POJO class
            pojoObject.setUserName("Hari Vigensh Jayapalan");
            pojoObject.setContent("Hello RecyclerView! item: " + iter);
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
