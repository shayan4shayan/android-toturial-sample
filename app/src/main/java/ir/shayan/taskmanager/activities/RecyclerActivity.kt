package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.adapters.RecyclerAdapter
import ir.shayan.taskmanager.model.Task
import kotlinx.android.synthetic.main.activity_recycler.*
import java.util.ArrayList

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val items = getList()
        val adapter = RecyclerAdapter(items)
        recycler.adapter = adapter

        adapter.notifyDataSetChanged()

        Handler().postDelayed({
            items.add(5,Task(100,"title","description"))
            adapter.notifyItemInserted(5)
        },5000)
    }

    private fun getList(): ArrayList<Task> {
        return ArrayList<Task>().apply {
            add(Task(1,"Buy some tea","must be done tomorrow"))
            add(Task(2,"Task 2","description2"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
            add(Task(3,"Task ","description3"))
        }
    }
}
