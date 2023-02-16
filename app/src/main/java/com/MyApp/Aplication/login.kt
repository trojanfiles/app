package com.MyApp.Aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btn: Button
    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        // View Binding
        btn = findViewById(R.id.btn_login)
        etEmail = findViewById(R.id.edt_email_login)
        etPass = findViewById(R.id.edt_password_login)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btn.setOnClickListener {
            val email = etEmail.text.toString()
            val pass = etPass.text.toString()


            // calling signInWithEmailAndPassword(email, pass)
            // function using Firebase auth object
            // On successful response Display a Toast
            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@login, home::class.java)
                    val value = etEmail.text.toString()
                    intent.putExtra("userkey1", value)
                    startActivityForResult(intent, REQUEST_CODE)

                    // using finish() to end the activity
                    finish()
                } else
                    Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object {
        private const val REQUEST_CODE = 10
    }

}
