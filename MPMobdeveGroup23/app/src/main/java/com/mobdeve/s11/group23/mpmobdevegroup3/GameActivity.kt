package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivityGameBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}