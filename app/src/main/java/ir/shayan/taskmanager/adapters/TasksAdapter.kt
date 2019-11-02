package ir.shayan.taskmanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.model.Task

class TasksAdapter(val items:ArrayList<Task>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item,parent,false)
        val task = items[position]
        val title = view.findViewById<TextView>(R.id.text_title)
        val description = view.findViewById<TextView>(R.id.text_description)
        title.text = task.title
        description.text = task.description

        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}