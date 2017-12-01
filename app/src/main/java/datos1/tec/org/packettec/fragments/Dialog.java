package datos1.tec.org.packettec.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;

import datos1.tec.org.packettec.activities.MainActivity;

/**
 * Created by Jai on 1/12/17.
 */

public class Dialog {
    public static void error(String error) {
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.getMainActivity()).create();

        dialog.setTitle("Error");
        dialog.setMessage(error);
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialoginterface, int i) {
            }
        });
        dialog.show();
    }
}
