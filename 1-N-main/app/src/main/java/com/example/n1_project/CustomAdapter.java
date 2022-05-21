package com.example.n1_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustormViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;


    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_make,parent,false);
        CustormViewHolder holder = new CustormViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustormViewHolder holder, int position) {
        holder.tv_tm.setText(arrayList.get(position).getTime());
        holder.tv_lc.setText(arrayList.get(position).getLocation());
        holder.tv_rn.setText(arrayList.get(position).getRn());
        holder.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mPosition = holder.getBindingAdapterPosition();
                context = v.getContext();
                Intent chamga = new Intent(context, chamga.class);
                chamga.putExtra("LOCATION",arrayList.get(mPosition).getLocation());

                ((Teammake)context).startActivity(chamga);

            }
        });



    }

    @Override
    public int getItemCount() {
        return (arrayList !=null ? arrayList.size() : 0);
    }

    public class CustormViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView tv_lc;
        TextView tv_tm;
        TextView tv_rn;

        public CustormViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_lc = itemView.findViewById(R.id.tv_lc);
            this.tv_rn = itemView.findViewById(R.id.tv_rn);
            this.tv_tm = itemView.findViewById(R.id.tv_tm);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }

}

