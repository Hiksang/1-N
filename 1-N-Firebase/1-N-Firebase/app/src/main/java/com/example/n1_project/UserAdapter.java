package com.example.n1_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {
    private Context context;

    ArrayList<User> list = new ArrayList<>();

    public UserAdapter(Context context, ArrayList<User> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.team_make, parent, false);
        return  new UserVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        User user = list.get(holder.getBindingAdapterPositon());

        //이름
        holder.nameText.setText(user.getUser_location());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    class UserVH extends RecyclerView.ViewHolder{
        TextView nameText;
        CardView cardView;
        public UserVH(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_text);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }
}
