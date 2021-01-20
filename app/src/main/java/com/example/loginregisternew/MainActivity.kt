package com.example.loginregisternew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener{
            val email = email_register.text.toString()
            val password = password_register.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("MainActivity","Email is : " + email)
            Log.d("MainActivity","Password is : $password")



            //Firebase Auth
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{

                    if (!it.isSuccessful) return@addOnCompleteListener

                    //else if successfull
                    Log.d("MainActivity","Successfully Created User with uid : ${it.result?.user?.uid}")

                }
                .addOnFailureListener{
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
        alreadyhaveacc_register.setOnClickListener{
            Log.d("MainActivity","Try to show login activity")

            //launch login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}