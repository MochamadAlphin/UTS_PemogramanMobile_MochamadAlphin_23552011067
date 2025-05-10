package com.example.uts_project_medicipaw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatList: List<ChatMessage>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.imageView_profile)
        val userName: TextView = itemView.findViewById(R.id.textView_name)
        val lastMessage: TextView = itemView.findViewById(R.id.textView_message)
        val time: TextView = itemView.findViewById(R.id.textView_time)
        val category: TextView = itemView.findViewById(R.id.textView_category) // Tambahkan ini
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        holder.profileImage.setImageResource(chat.profileImage)
        holder.userName.text = chat.userName
        holder.lastMessage.text = chat.lastMessage
        holder.time.text = chat.time
        holder.category.text = chat.category
    }

    override fun getItemCount() = chatList.size
}