package ir.shayan.taskmanager.tasks

import android.os.AsyncTask
import ir.shayan.taskmanager.database.AppDatabase
import ir.shayan.taskmanager.model.Task

class InsertTask(val db:AppDatabase,val callback: (List<Task>)->Unit):
        AsyncTask<Task,Unit,List<Task>?>(){
    override fun doInBackground(vararg params: Task?): List<Task>? {
        if (params.isEmpty()) return null
        var id = db.getNewTaskId()
        params.forEach { it?.id = id; id ++ }
        db.getTasksDao().inserAllTasks(params.toList().map { it!! })


        return params.toList().map { it!! }
    }

    override fun onPostExecute(result: List<Task>?) {
        if (result!=null)
            callback(result)
    }
}