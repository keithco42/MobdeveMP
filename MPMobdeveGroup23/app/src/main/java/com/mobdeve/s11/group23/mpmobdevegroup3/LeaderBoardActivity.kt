package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityLeaderBoardBinding

class LeaderBoardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivityLeaderBoardBinding = ActivityLeaderBoardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        this.recyclerView = findViewById(R.id.recyclerView)
        this.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}