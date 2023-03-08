package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivitySettingBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}