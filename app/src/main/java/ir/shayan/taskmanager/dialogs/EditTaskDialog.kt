package ir.shayan.taskmanager.dialogs

import android.content.Context
import ir.shayan.taskmanager.R
import kotlinx.android.synthetic.main.dialog_new_task.*

class EditTaskDialog (context: Context,callback : (String,String) -> (Unit)) :
        NewTaskDialog(context,callback){
    override fun show() {
        super.show()
        title.text = context.getString(R.string.title_edit_task)
        btn_add.text = context.getString(R.string.edit)
    }
}