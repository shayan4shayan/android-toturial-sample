package ir.shayan.taskmanager.tasks

import android.content.Context
import android.os.AsyncTask
import ir.shayan.taskmanager.database.AppDatabase
import ir.shayan.taskmanager.model.Task

class SelectAllTasks(val db: AppDatabase, val callback: (List<Task>) -> Unit) :
    AsyncTask<Unit, Unit, List<Task>>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Unit?): List<Task> {
        return db.getTasksDao().selectAll()
    }

    override fun onPostExecute(result: List<Task>?) {
        if (result != null)
            callback(result)
    }
}