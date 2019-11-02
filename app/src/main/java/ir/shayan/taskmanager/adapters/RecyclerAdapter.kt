package ir.shayan.taskmanager.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.model.Task
import ir.shayan.taskmanager.toast

class RecyclerAdapter(val items:ArrayList<Task>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            parent.context.toast("item in position ${viewHolder.adapterPosition} clicked")
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        Log.d("Adapter","$position")
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.text_title)
        val description = view.findViewById<TextView>(R.id.text_description)

    }
}