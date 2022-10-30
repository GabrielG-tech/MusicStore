package br.edu.infnet.musicstore.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tipo(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val nome : String = ""

)
