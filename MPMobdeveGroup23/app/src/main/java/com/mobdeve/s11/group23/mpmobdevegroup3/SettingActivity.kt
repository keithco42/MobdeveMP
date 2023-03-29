package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivitySettingBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(firebaseAuth.currentUser!!.uid).get().addOnSuccessListener {
            val username = it.child("username").value
            var firstname = it.child("firstname").value
            var lastname = it.child("lastname").value
            var email = it.child("email").value
            var password = it.child("password").value
            viewBinding.firstname.setText (firstname.toString())
            viewBinding.username.setText(username.toString())
            viewBinding.email.setText (email.toString())
            viewBinding.password.setText(password.toString())
            viewBinding.lastname.setText(lastname.toString())
        }



        viewBinding.signout.setOnClickListener{
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            val intent = Intent(applicationContext, MainActivity::class.java)
            this.startActivity(intent);
        }
    }
}