package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.adapters.RecyclerAdapter
import ir.shayan.taskmanager.dialogs.NewTaskDialog
import ir.shayan.taskmanager.getAppDatabase
import ir.shayan.taskmanager.getRequestQueue
import ir.shayan.taskmanager.model.Task
import ir.shayan.taskmanager.tasks.InsertTask
import ir.shayan.taskmanager.tasks.SelectAllTasks
import ir.shayan.taskmanager.toast
import kotlinx.android.synthetic.main.activity_recycler.*
import org.json.JSONArray
import java.util.ArrayList

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        getList()

        addTask.setOnClickListener {
            addNewTask()
        }


    }

    private fun addNewTask() {
        NewTaskDialog(this) { title, desc ->
            InsertNewTask(Task(0, title, desc))
        }.show()
    }

    private fun InsertNewTask(task: Task) {
        InsertTask(getAppDatabase()) {
            //            it.forEach {
//                val adapter  = recycler.adapter as RecyclerAdapter
//                adapter.items.add(it)
//                recycler.adapter?.notifyItemInserted(adapter.items.size-1)
//            }
            val adapter = recycler.adapter as RecyclerAdapter
            val size = adapter.items.size
            adapter.items.addAll(it)
            adapter.notifyItemRangeInserted(size, adapter.items.size)

            addTaskToServer(task)

        }.execute(task)
    }

    private fun addTaskToServer(task: Task) {

        val request = JsonObjectRequest(Request.Method.POST,
            "http://10.0.2.2:8000/api/tasks/",
            task.toJson(),
            Response.Listener {
                toast("${task.title} saved to server")
                Log.d("ServerResponse", it.toString())
            },
            Response.ErrorListener {
                Log.e("ServerError", it.message ?: "error message is empty")
                // handle error here
            })

        getRequestQueue().add(request)
    }

    private fun getList() {


        val request = JsonArrayRequest(
            Request.Method.GET,
            "http://10.0.2.2:8000/api/tasks/",
            null,
            Response.Listener {
                val items = parseArray(it)
                displayItems(items)
            },
            Response.ErrorListener {
                Log.e("ServerError", it.message ?: "message is null")
                toast("error getting tasks list from server")
                //retry ...
                SelectAllTasks(getAppDatabase()) { tasks->
                    displayItems(tasks)
                }.execute()
            })
        getRequestQueue().add(request)
    }

    private fun displayItems(items: List<Task>) {
        val adapter = RecyclerAdapter(ArrayList(items))
        recycler.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    private fun parseArray(jsonArray: JSONArray): List<Task> {
        return (0 until jsonArray.length()).map {
            jsonArray.getJSONObject(it)
        }.map {
            Task(it.getInt("id"), it.getString("title"), it.getString("description"))
                .apply {
                    isDone = it.getBoolean("is_done")
                }
        }
    }
}
