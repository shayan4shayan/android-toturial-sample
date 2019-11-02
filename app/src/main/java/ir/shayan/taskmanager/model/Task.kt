package ir.shayan.taskmanager.model

data class Task(val id:Int,var title:String,var description: String){
    var isDone = false

    fun done() { isDone = true }
}