package datos1.tec.org.packettec.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.adapters.MessagesAdaptor;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_message, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recycler_messages);

        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(20));

        recyclerView.setAdapter(adapter);

        MessagesAdaptor adaptor = new MessagesAdaptor();
        recyclerView.setAdapter(adaptor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adaptor = new MessagesAdaptor();
        //populateRecyclerViewValues();


        return v;

    }

//    public void populateRecyclerViewValues(String sender,String body) {
//
//        ArrayList<Message> listContentArr = new ArrayList<>();
//
//        //Creating POJO class object
//        Message conversations = new Message();
//        //Values are binded using set method of the POJO class
//        Message.setUserName(sender);
//        Message.setContent(body);
//        //After setting the values, we add all the Objects to the array
//        //Hence, listConentArr is a collection of Array of POJO objects
//
//        listContentArr.add(conversations);
//
//        //We set the array to the adapter
//        adapter.setListContent(listContentArr);
//        //We in turn set the adapter to the RecyclerView
//        recyclerView.setAdapter(adapter);
//    }

}
