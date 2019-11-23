package ir.shayan.taskmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.shayan.taskmanager.model.Task

@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTasksDao() : TasksDao

    fun getNewTaskId():Int{
        val list =  getTasksDao().selectAllIds()
        return if (list.isEmpty()) 0
        else getTasksDao().selectAllIds().last() + 1
    }

    companion object {
        private var db: AppDatabase? = null
        fun getInstance(appContext: Context): AppDatabase {
            if (db == null)
                db = Room.databaseBuilder(appContext, AppDatabase::class.java, "database").build()
            return db!!
        }
    }
}