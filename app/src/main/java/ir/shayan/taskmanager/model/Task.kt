package ir.shayan.taskmanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity
data class Task(
    @PrimaryKey
    var id:Int,var title:String,var description: String){

    @ColumnInfo(name = "is_done")
    var isDone = false

    fun done() { isDone = true }
    fun toJson(): JSONObject {
        return JSONObject().apply {
            put("title",title)
            put("description",description)
            put("is_done",isDone)
        }
    }
}