package ir.shayan.taskmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shayan.taskmanager.R
import kotlinx.android.synthetic.main.activity_login.*
import ir.shayan.taskmanager.login
import ir.shayan.taskmanager.startSomeActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            if (isValid()) {
                performLogin()
            }
        }
    }

    private fun performLogin() {
        login(email.text.toString())
        startSomeActivity(MainActivity::class.java)
    }

    private fun isValid(): Boolean {
        var isValid = true
        val textEmail = email.text.toString()
        val textPasword = password.text.toString()
        if (textEmail.isEmpty()) {
            isValid = false
            layoutEmail.error = getString(R.string.error_email_empty)
        } else if (!textEmail.contains("@") || textEmail.lastIndexOf('.') < textEmail.indexOf("@")) {
            isValid = false
            layoutEmail.error = getString(R.string.error_email_invalid)
        } else {
            layoutEmail.error = null
        }
        if (textPasword.length < 8) {
            isValid = false
            layoutPassword.error = getString(R.string.error_password)
        }
        return isValid
    }
}
