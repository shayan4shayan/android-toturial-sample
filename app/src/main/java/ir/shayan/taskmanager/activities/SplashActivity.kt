package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.isLogin
import ir.shayan.taskmanager.startSomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (isLogin()){
            startSomeActivity(MainActivity::class.java)
        } else {
            startSomeActivity(LoginActivity::class.java)
        }
    }
}
