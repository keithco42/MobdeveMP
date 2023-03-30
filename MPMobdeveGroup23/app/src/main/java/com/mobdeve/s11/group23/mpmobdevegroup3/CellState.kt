package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.annotation.DrawableRes

sealed class CellState(@DrawableRes val res: Int) {
    object Blank : CellState(R.drawable.ic_blank)
    object Cross : CellState(R.drawable.x_icon)
    object Circle : CellState(R.drawable.o_icon)
}
