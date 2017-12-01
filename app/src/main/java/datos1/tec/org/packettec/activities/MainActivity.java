package datos1.tec.org.packettec.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.fragments.ChatFragment;
import datos1.tec.org.packettec.fragments.ConversationsMainFragment;
import datos1.tec.org.packettec.fragments.LoginFragment;
import datos1.tec.org.packettec.fragments.MainFragment;
import datos1.tec.org.packettec.fragments.NewMessageFragment;
import datos1.tec.org.packettec.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;
    public static String myUserName = "";

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = LoginFragment.newInstance("blah", "kah");
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
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

    public void loadConversationsMainFragment() {

        ConversationsMainFragment conversationsMainFragment = new ConversationsMainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, conversationsMainFragment).addToBackStack(null).commit();

    }

}

