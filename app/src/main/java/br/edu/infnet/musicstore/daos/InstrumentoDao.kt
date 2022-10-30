package br.edu.infnet.musicstore.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.edu.infnet.musicstore.models.Instrumento

@Dao
interface InstrumentoDao {

    // Criar
    @Insert
    fun insert(instrumento: Instrumento)

    // Ler
    @Query("SELECT * FROM Instrumento WHERE Instrumento.id = :id")
    fun getById(id: Long): Instrumento

    // Atualizar
    @Update
    fun update(instrumento: Instrumento)

    // Deletar
    @Delete
    fun delete(instrumento: Instrumento)

    // Pegar todos Instrumentos
    @Query("SELECT * FROM Instrumento")
    fun getAll(): List<Instrumento>

    // Pegar todos Instrumentos pelo id do Tipo
    @Query("SELECT * FROM Instrumento WHERE tipoId = :id")
    fun getInstrumentosByTipoId(id: Long) : List<Instrumento>
    
}