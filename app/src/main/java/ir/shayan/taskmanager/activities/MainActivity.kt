package ir.shayan.taskmanager.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shayan.taskmanager.R
import ir.shayan.taskmanager.username
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = username()

        startActivity(Intent(this,RecyclerActivity::class.java))

    }
}
