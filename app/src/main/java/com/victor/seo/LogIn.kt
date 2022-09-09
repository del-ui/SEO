package com.victor.seo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogIn : AppCompatActivity() {

private lateinit var edtEmail: EditText
private lateinit var edtPassword: EditText
private lateinit var btnLogin: Button
private lateinit var btnSign: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        edtEmail = findViewById(R.id.email_id)
        edtPassword = findViewById(R.id.pass_id)
        btnLogin = findViewById(R.id.login_btn)
        btnSign = findViewById(R.id.sign_btn)

        btnSign.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

    }
}