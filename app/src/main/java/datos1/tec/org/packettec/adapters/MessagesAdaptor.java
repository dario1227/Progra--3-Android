package datos1.tec.org.packettec.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.holders.MessagesViewHolder;
import datos1.tec.org.packettec.model.Messages;


public class MessagesAdaptor extends RecyclerView.Adapter<MessagesViewHolder> {

    private ArrayList<Messages> listMembers = new ArrayList<>();


    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convoRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_bubble, parent, false);
        return new MessagesViewHolder(convoRow);
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, int position) {
        final Messages messages = listMembers.get(position);
        holder.updateUI(messages);

    }

    @Override
    public int getItemCount() {
        return listMembers.size();
    }

    public void setListContent(ArrayList<Messages> list_members) {
        this.listMembers = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }

    public void removeAt(int position) {
        listMembers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, listMembers.size());
    }
}
