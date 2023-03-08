package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.loginButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, MenuActivity::class.java)

            this.startActivity(intent);
        })

        viewBinding.signUpButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, SignUpActivity::class.java)

            this.startActivity(intent);
        })
    }
}