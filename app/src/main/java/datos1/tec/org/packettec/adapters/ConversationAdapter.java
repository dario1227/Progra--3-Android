package datos1.tec.org.packettec.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.holders.ConversationsViewHolder;
import datos1.tec.org.packettec.model.Conversations;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationsViewHolder> {

    private ArrayList<Conversations> listMembers = new ArrayList<>();


    @Override
    public ConversationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convoRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.convo_row, parent, false);
        return new ConversationsViewHolder(convoRow);
    }

    @Override
    public void onBindViewHolder(ConversationsViewHolder holder, int position) {
        final Conversations conversations = listMembers.get(position);
        holder.updateUI(conversations);

    }

    @Override
    public int getItemCount() {
        return listMembers.size();
    }

    public void setListContent(ArrayList<Conversations> list_members) {
        this.listMembers = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }

    public void removeAt(int position) {
        listMembers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, listMembers.size());
    }

}
