package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.adapters.TasksAdapter
import ir.shayan.taskmanager.model.Task
import ir.shayan.taskmanager.toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        list.adapter = TasksAdapter(getItems())

        list.setOnItemClickListener { parent, view, position, id ->
            toast("clicked on item with position: $position")
        }
    }

    private fun getItems(): ArrayList<Task> {
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
