package com.victor.seo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSign: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportActionBar?.hide()

        edtName = findViewById(R.id.name_id)
        edtEmail = findViewById(R.id.email_id)
        edtPassword = findViewById(R.id.pass_id)
        btnLogin = findViewById(R.id.login_btn)
        btnSign = findViewById(R.id.sign_btn)
        mAuth = FirebaseAuth.getInstance()


        btnSign.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signIn(email,password)
        }

    }
    private fun signIn(email: String, password: String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@SignIn, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignIn, "Error Signing up",Toast.LENGTH_SHORT).show()

                }
            }

    }


}