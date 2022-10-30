package br.edu.infnet.musicstore.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = Tipo::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("tipoId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Instrumento(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val tipoId: Long = 0L,
    val nome: String = ""
)
