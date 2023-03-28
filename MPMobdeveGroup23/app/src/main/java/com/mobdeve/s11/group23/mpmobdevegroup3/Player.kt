package com.mobdeve.s11.group23.mpmobdevegroup3

data class Player(
    val firstname: String? = null,
    val lastname: String? = null,
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val wins: Int = 0 // add default value for wins
) {
    // no-argument constructor
    constructor() : this(null, null, null, null, null, 0)
}
