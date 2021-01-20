package com.example.loginregisternew

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            val email = email_login.text.toString()
            val password = password_login.text.toString()

            Log.d("Login","Attempt login with email/pass : $email/***")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if(!it.isSuccessful){
                        return@addOnCompleteListener
                    }
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "${it.message }}", Toast.LENGTH_SHORT).show()
                }
        }


        backtoregis_login.setOnClickListener {
            finish()
        }

    }
}