package br.edu.infnet.musicstore.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.edu.infnet.musicstore.models.Tipo

@Dao
interface TipoDao {

    // CRUD:

    // Create
    @Insert
    fun insert(tipo: Tipo)

    // Read
    @Query("SELECT * FROM Tipo WHERE Tipo.id = :id")
    fun getById(id: Long): Tipo

    // Update
    @Update
    fun update(tipo: Tipo)

    // Delete
    @Delete
    fun delete(tipo: Tipo)


    @Query("SELECT * FROM Tipo")
    fun getAll(): List<Tipo>
    
}