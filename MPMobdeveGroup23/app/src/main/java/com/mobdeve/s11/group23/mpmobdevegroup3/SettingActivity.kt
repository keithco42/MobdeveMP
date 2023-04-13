package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var viewBinding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(firebaseAuth.currentUser!!.uid).get().addOnSuccessListener { dataSnapshot ->
            val username = dataSnapshot.child("username").value
            var firstname = dataSnapshot.child("firstname").value
            var lastname = dataSnapshot.child("lastname").value
            var email = dataSnapshot.child("email").value
            var password = dataSnapshot.child("password").value

            viewBinding.firstname.setText(firstname.toString())
            viewBinding.username.setText(username.toString())
            viewBinding.email.setText(email.toString())
            viewBinding.password.setText(password.toString())
            viewBinding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            viewBinding.lastname.setText(lastname.toString())
        }

        viewBinding.update.setOnClickListener {
            val newUsername = viewBinding.username.text.toString()
            val newFirstname = viewBinding.firstname.text.toString()
            val newLastname = viewBinding.lastname.text.toString()
            val newEmail = viewBinding.email.text.toString()
            val newPassword = viewBinding.password.text.toString()

            val updates = hashMapOf<String, Any>(
                "username" to newUsername,
                "firstname" to newFirstname,
                "lastname" to newLastname,
                "email" to newEmail,
                "password" to newPassword
            )

            if (newUsername.isEmpty() || newFirstname.isEmpty() || newLastname.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this@SettingActivity, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            database.child(firebaseAuth.currentUser!!.uid).updateChildren(updates)
                .addOnSuccessListener {

                    val user = FirebaseAuth.getInstance().currentUser
                    user?.updateEmail(newEmail)
                        ?.addOnSuccessListener {
                            user.updatePassword(newPassword)
                                .addOnSuccessListener {
                                    Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { exception ->
                                    Toast.makeText(
                                        this@SettingActivity,
                                        "Failed to update password: ${exception.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        }
                        ?.addOnFailureListener { exception ->
                            Toast.makeText(
                                this@SettingActivity,
                                "Failed to update email: ${exception.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(
                        this@SettingActivity,
                        "Failed to update user data: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        viewBinding.signout.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            val intent = Intent(applicationContext, MainActivity::class.java)

            this.startActivity(intent)
            finish()
        }
    }
}