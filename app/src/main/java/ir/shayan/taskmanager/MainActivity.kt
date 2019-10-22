package ir.shayan.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textLink.text = "hello"

        button1.text = "click me"

        button1.setOnClickListener {
            val content = editTextHint.text.toString()
        }
    }
}
