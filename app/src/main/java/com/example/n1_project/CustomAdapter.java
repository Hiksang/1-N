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
        holder.itemView.setTag(position);
        holder.tv_tm.setText(arrayList.get(position).getTime());
        holder.tv_lc.setText(arrayList.get(position).getLocation());
        holder.tv_rn.setText(arrayList.get(position).getRn());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tv_tm2 = holder.tv_tm.getText().toString();
                String tv_lc2 = holder.tv_lc.getText().toString();
                String tv_rn2 = holder.tv_rn.getText().toString();

                Intent intent44;
                intent44 = new Intent(context, chamga.class);
                intent44.putExtra("tv_tm2",tv_tm2);
                intent44.putExtra("tv_lc2",tv_lc2);
                intent44.putExtra("tv_rn2",tv_rn2);
                context.startActivity(intent44);


            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList !=null ? arrayList.size() : 0);
    }

    public class CustormViewHolder extends RecyclerView.ViewHolder {
        TextView tv_lc;
        TextView tv_tm;
        TextView tv_rn;

        public CustormViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_lc = itemView.findViewById(R.id.tv_lc);
            this.tv_rn = itemView.findViewById(R.id.tv_rn);
            this.tv_tm = itemView.findViewById(R.id.tv_tm);
        }
    }
}

