package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        viewBinding.loginButton.setOnClickListener {
            val email = viewBinding.loginemail.text.toString()
            val password = viewBinding.loginpassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, MenuActivity::class.java)

                        this.startActivity(intent);
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are Not Allowed", Toast.LENGTH_SHORT).show()
            }

        }

        viewBinding.forgotpassword.setOnClickListener{
            val intent = Intent(applicationContext, ForgotPasswordActivity::class.java)

            this.startActivity(intent);
        }

        viewBinding.signUpButton.setOnClickListener{
            val intent = Intent(applicationContext, SignUpActivity::class.java)

            this.startActivity(intent);
        }
    }
}