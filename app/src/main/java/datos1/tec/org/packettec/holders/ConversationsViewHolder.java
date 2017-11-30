package datos1.tec.org.packettec.holders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.model.Conversations;

public class ConversationsViewHolder extends RecyclerView.ViewHolder {

    private TextView userName;
    private TextView content;
    private TextView time;


    public ConversationsViewHolder(View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.user_name);
        content = itemView.findViewById(R.id.content);
        time = itemView.findViewById(R.id.time);

    }

    public void updateUI(Conversations conversations) {
        userName.setText(conversations.getName());
        content.setText(conversations.getContent());
        time.setText(conversations.getTime());

    }

}