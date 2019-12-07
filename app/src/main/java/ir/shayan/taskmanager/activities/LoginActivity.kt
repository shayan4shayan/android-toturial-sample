package ir.shayan.taskmanager.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shayan.taskmanager.R
import kotlinx.android.synthetic.main.activity_login.*
import ir.shayan.taskmanager.login
import ir.shayan.taskmanager.startSomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignIn
import android.content.Intent
import ir.shayan.taskmanager.toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException
import android.util.Log


class LoginActivity : AppCompatActivity() {

    val RC_SIGN_IN = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            if (isValid()) {
                performLogin()
            }
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(getString(R.string.google_client_id))
            .requestProfile()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        if (account!=null){
            login(account.email!!)
            startSomeActivity(MainActivity::class.java)
        }

        google_login.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SIGN_IN){
            if (resultCode != Activity.RESULT_CANCELED){
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task)
            } else {
                toast(getString(R.string.error_google_login))
                Log.d("LoginActivity","Error")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>){
        try {
            val account = task.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            login(account!!.email!!)
            startSomeActivity(MainActivity::class.java)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("LoginActivity", "signInResult:failed code=" + e.statusCode)
            toast(getString(R.string.error_google_login))
        }

    }
}
