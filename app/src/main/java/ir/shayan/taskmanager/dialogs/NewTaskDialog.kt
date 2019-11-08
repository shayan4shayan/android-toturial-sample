package ir.shayan.taskmanager.dialogs

import android.app.AlertDialog
import android.content.Context
import ir.shayan.taskmanager.R
import android.view.WindowManager
import kotlinx.android.synthetic.main.dialog_new_task.*
import kotlinx.android.synthetic.main.list_item.*


open class NewTaskDialog(context: Context, val callback : (String, String)->Unit) : AlertDialog(context){
    override fun show() {
        super.show()
        setContentView(R.layout.dialog_new_task)
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        btn_add.setOnClickListener {
            val title = text_title.text.toString()
            val description = text_description.text.toString()
            if (isValid(title,description)){
                callback(title,description)
            } else {
                layout_task_title.error = context.getString(R.string.error_field_empty)
                layout_task_description.error = context.getString(R.string.error_field_empty)
            }
        }
    }

    private fun isValid(title: String, description: String) = title.isNotEmpty() and description.isNotEmpty()
}