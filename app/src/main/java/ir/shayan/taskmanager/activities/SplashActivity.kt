package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.isLogin
import ir.shayan.taskmanager.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (isLogin()){
            startActivity(MainActivity::class.java)
        } else {
            startActivity(LoginActivity::class.java)
        }
    }
}
