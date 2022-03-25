package com.example.myexample2.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myexample2.R
import com.example.myexample2.ui.main.db.User

class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var userList: List<User> = arrayListOf()
    fun setUserData(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User) {
            val textViewName = itemView.findViewById(R.id.name) as TextView
            textViewName.text = user.email
        }
    }
}