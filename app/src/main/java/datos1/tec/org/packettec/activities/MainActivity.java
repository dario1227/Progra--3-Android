package datos1.tec.org.packettec.activities;


import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.fragments.ChatFragment;
import datos1.tec.org.packettec.fragments.LoginFragment;
import datos1.tec.org.packettec.fragments.MainFragment;
import datos1.tec.org.packettec.fragments.NewMessageFragment;
import datos1.tec.org.packettec.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener,LoginFragment.LoginFragmentInteractionListener, MainFragment.OnFragmentInteractionListener, NewMessageFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener, ChatFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        MainActivity.setOnClickListener(this);
        if (fragment == null) {
            fragment = new LoginFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }

    }
    @Override
    Public void OnClick{
        new Thread(new Runnable() {
            public void run() {

                try{
                    URL url = new URL("URL!!!!!!!!!!!");
                    URLConnection connection = url.openConnection();

                    String inputString = inputValue.getText().toString();
                    //inputString = URLEncoder.encode(inputString, "UTF-8");

                    Log.d("inputString", inputString);

                    connection.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                    out.write(inputString);
                    out.close();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String returnString="";
                    doubledValue =0;

                    while ((returnString = in.readLine()) != null)
                    {
                        doubledValue= Integer.parseInt(returnString);
                    }
                    in.close();


                    runOnUiThread(new Runnable() {
                        public void run() {

                            inputValue.setText(doubledValue.toString());

                        }
                    });

                }catch(Exception e)
                {
                    Log.d("Exception",e.toString());
                }

            }
        }).start();
    }

    public void loadMainFragment() {

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();

    }

    public void loadSearchFragment() {

        SearchFragment SearchFragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SearchFragment).addToBackStack(null).commit();

    }

    public void loadNewMessageFragment() {

        NewMessageFragment newMessageFragment = new NewMessageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newMessageFragment).addToBackStack(null).commit();

    }

    public void loadChatFragment() {

        ChatFragment chatFragment = new ChatFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, chatFragment).addToBackStack(null).commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

