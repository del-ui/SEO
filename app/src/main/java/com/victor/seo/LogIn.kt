package com.victor.seo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

private lateinit var edtEmail: EditText
private lateinit var edtPassword: EditText
private lateinit var btnLogin: Button
private lateinit var btnSign: Button
private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        edtEmail = findViewById(R.id.email_id)
        edtPassword = findViewById(R.id.pass_id)
        btnLogin = findViewById(R.id.login_btn)
        btnSign = findViewById(R.id.sign_btn)
        mAuth = FirebaseAuth.getInstance()

        btnSign.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email,password)
        }

    }

    private fun login(email:String, password: String){

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@LogIn, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@LogIn, "User does not exist", Toast.LENGTH_SHORT).show()

                }
            }

    }


}