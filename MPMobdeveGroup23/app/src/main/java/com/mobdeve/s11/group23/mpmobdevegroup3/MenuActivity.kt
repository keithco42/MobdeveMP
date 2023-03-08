package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding: ActivityMenuBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.play.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)

            this.startActivity(intent);
        })

        viewBinding.leaderboards.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, LeaderBoardActivity::class.java)

            this.startActivity(intent);
        })

        viewBinding.settings.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, SettingActivity::class.java)

            this.startActivity(intent);
        })

        viewBinding.about.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, About::class.java)

            this.startActivity(intent);
        })
    }
}