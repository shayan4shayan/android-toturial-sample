package ir.shayan.taskmanager.database

import androidx.room.*
import ir.shayan.taskmanager.model.Task

@Dao
interface TasksDao {
    @Insert
    fun insertNewTask(task: Task)

    @Insert
    fun inserAllTasks(tasks: List<Task>)

    @Update
    fun updateTask(task: Task)

    @Update
    fun updateTasks(tasks: List<Task>)

    @Delete
    fun deleteTask(task: Task)

    @Delete
    fun deleteTasks(tasks: List<Task>)

    @Query("SELECT * from task ;")
    fun selectAll(): List<Task>

    @Query("Select * from task WHERE is_done=1;")
    fun selectDoneTasks(): List<Task>

    @Query("Select * from task WHERE is_done=0;")
    fun selectUnDoneTasks():List<Task>

    @Query("Select id from task;")
    fun selectAllIds():List<Int>
}