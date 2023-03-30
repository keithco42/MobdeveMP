package com.mobdeve.s11.group23.mpmobdevegroup3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ItemLayoutBinding

class MyAdapter(private val context: Context, private val data: ArrayList<Player>) : RecyclerView.Adapter<MyViewHolder>() {

    private val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
    private lateinit var valueEventListener: ValueEventListener

    private val query = databaseReference.orderByChild("wins").limitToFirst(10)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding: ItemLayoutBinding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return MyViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(this.data[position])
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
    fun fetchPlayers() {
        // Get the top 10 players by score
        val query = databaseReference.orderByChild("wins").limitToFirst(10)

        valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Convert the snapshot to a list of Player objects
                val players = snapshot.children.mapNotNull { it.getValue(Player::class.java) }

                // Update the adapter with the new list of players
                data.clear()
                data.addAll(players.reversed())
                notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to fetch Players", Toast.LENGTH_SHORT).show()
            }
        }

        query.addValueEventListener(valueEventListener)
    }

    fun stopFetchingPlayers() {
        query.removeEventListener(valueEventListener)
    }
}