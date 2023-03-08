package com.mobdeve.s11.group23.mpmobdevegroup3

class DataHelper {
    companion object{
        fun loadData(): ArrayList<Player> {
            var data = ArrayList<Player>()
            data.add(Player(
                "Rafael", 0))
            data.add(Player(
                "Keith", 0))
            data.add(Player(
                "Mark", 0))
            return data
        }
    }
}