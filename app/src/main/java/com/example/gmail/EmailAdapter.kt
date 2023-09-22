package com.example.gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderTextView: TextView
        val etitleTextView: TextView
        val summaryTextView: TextView
        // TODO: Create member variables for any view that will be set
        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            senderTextView = itemView.findViewById(R.id.sender)
            etitleTextView =  itemView.findViewById(R.id.etitle)
            summaryTextView =  itemView.findViewById(R.id.summary)
        }
    }
    // Provide a direct reference to each of the views within a data item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.email_item,parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: EmailAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.etitleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}
