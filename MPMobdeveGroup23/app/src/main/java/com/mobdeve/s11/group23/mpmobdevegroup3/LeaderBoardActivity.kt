package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ActivityLeaderBoardBinding

class LeaderBoardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding : ActivityLeaderBoardBinding = ActivityLeaderBoardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        this.recyclerView = findViewById(R.id.recyclerView)
        this.recyclerView.layoutManager = LinearLayoutManager(this)

        // create an empty list to store data
        val data = ArrayList<Player>()

        myAdapter = MyAdapter(applicationContext,data)

        // set the adapter to the recyclerview
        recyclerView.adapter = myAdapter

        // fetch the data from Firebase
        myAdapter.fetchPlayers()

    }

    override fun onDestroy() {
        super.onDestroy()
        myAdapter.stopFetchingPlayers()
    }
}