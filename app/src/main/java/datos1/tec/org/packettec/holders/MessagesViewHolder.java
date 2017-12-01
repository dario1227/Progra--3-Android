package datos1.tec.org.packettec.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.model.Messages;


public class MessagesViewHolder extends RecyclerView.ViewHolder {
    private TextView userName;
    private TextView content;
    private TextView special;

    public MessagesViewHolder(View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.user_name);
        content = itemView.findViewById(R.id.content);
    }

    public void updateUI(Messages messages) {
        userName.setText(messages.getUserName());
        content.setText(messages.getContent());
        special.setText(messages.getSpecial());
    }
}
