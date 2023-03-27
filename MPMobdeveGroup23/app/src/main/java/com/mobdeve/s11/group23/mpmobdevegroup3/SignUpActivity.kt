package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.createButton.setOnClickListener{

            val firstname = viewBinding.firstname.text.toString()
            val lastname = viewBinding.lastname.text.toString()
            val username = viewBinding.username.text.toString()
            val email = viewBinding.email.text.toString()
            val password = viewBinding.password.text.toString()

            if(firstname.isNotEmpty() && lastname.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                database = FirebaseDatabase.getInstance().getReference("Users")
                val User = Player(firstname, lastname, username, email, password, wins = 0)
                database.child(username).setValue(User).addOnSuccessListener {
                    viewBinding.firstname.text.clear()
                    viewBinding.lastname.text.clear()
                    viewBinding.username.text.clear()
                    viewBinding.email.text.clear()
                    viewBinding.password.text.clear()

                    firebaseAuth = FirebaseAuth.getInstance()
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)

                    this.startActivity(intent);
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty Fields Are Not Allowed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}