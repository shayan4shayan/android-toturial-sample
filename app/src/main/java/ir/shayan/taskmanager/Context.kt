package ir.shayan.taskmanager

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.toast(content: String) {
    Toast.makeText(this, content, Toast.LENGTH_LONG).show()
}

fun Context.isLogin(): Boolean {
    return getSharedPreferences("App", Context.MODE_PRIVATE).getBoolean("isLogin", false)
}

fun Context.login(username: String) {
    val prefs = getSharedPreferences("App", Context.MODE_PRIVATE).edit()
    prefs.putBoolean("isLogin", true)
    prefs.putString("username", username)
    prefs.apply()
}

fun Context.username(): String? {
    return getSharedPreferences("App",Context.MODE_PRIVATE).getString("username",getString(R.string.guest))
}

fun <T : Activity> Context.startSomeActivity(activity: Class<T>) {
    Intent(this, activity).apply {
        startActivity(this)
    }
}