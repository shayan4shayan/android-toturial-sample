package ir.shayan.taskmanager

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.toast(content:String){
    Toast.makeText(this,content,Toast.LENGTH_LONG).show()
}
fun Context.isLogin() : Boolean{
    return getSharedPreferences("App",Context.MODE_PRIVATE).getBoolean("isLofin",false)
}

fun Context.startActivity(activity : Class<Activity>){
    Intent(this,activity).apply {
        startActivity(this)
    }
}