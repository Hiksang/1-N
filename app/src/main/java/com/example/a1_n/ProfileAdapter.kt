package com.example.a1_n

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>): RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.cost.text = profileList.get(position).cost.toString()
        holder.predict.text = profileList.get(position).predict
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView?.context, MainActivity3::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent,null)
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val gender = itemview.findViewById<ImageView>(R.id.iv_profile)//식당 사진
        val name   = itemview.findViewById<TextView>(R.id.tv_name)//이름
        val cost   = itemview.findViewById<TextView>(R.id.tv_cost)//배달최소금액
        val predict   = itemview.findViewById<TextView>(R.id.tv_greet)//배달예정시간
    }

}