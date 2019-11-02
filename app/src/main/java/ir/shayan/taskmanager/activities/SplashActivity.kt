package ir.shayan.taskmanager.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Explode
import android.transition.Transition
import android.view.Window
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.isLogin
import ir.shayan.taskmanager.startSomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            if (isLogin()){
                startSomeActivity(MainActivity::class.java)
            } else {
                startActivity(Intent(this,LoginActivity::class.java),
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        },2000)
    }
}
