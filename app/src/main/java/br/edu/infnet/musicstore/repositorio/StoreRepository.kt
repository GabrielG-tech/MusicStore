package br.edu.infnet.musicstore.repositorio

import android.content.Context
import androidx.room.Room
import br.edu.infnet.musicstore.database.StoreDatabase
import br.edu.infnet.musicstore.models.Instrumento
import br.edu.infnet.musicstore.models.Tipo


private const val DATABASE_NAME = "store-db"

class StoreRepository private constructor(context: Context) {

    private val database: StoreDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            StoreDatabase::class.java,
            DATABASE_NAME
        )
        .build()

    companion object {
        private var INSTANCE: StoreRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = StoreRepository(context)
            }
        }

        fun get(): StoreRepository {
            return INSTANCE
                ?: throw IllegalStateException("StoreRepository deve ser inicializado.")
        }
    }

    // Chamar o DAO:
    fun insertTipo(tipo: Tipo){
        database.tipoDao().insert(tipo)
    }

    fun getTipoById(id: Long) : Tipo{
        return database.tipoDao().getById(id)
    }

    fun deleteTipo(tipo: Tipo) {
        database.tipoDao().delete(tipo)
    }

    fun updateTipo(tipo: Tipo){
        database.tipoDao().update(tipo)
    }

    fun getAllTipo(): List<Tipo> {
        return database.tipoDao().getAll()
    }

    // Instrumentos:

    fun insertInstrumento(instrumentos: Instrumento){
        database.instrumentoDao().insert(instrumentos)
    }

    fun getInstrumentoById(id: Long) : Instrumento{
        return database.instrumentoDao().getById(id)
    }

    fun deleteInstrumento(instrumentos: Instrumento) {
        database.instrumentoDao().delete(instrumentos)
    }

    fun updateInstrumento(instrumentos: Instrumento){
        database.instrumentoDao().update(instrumentos)
    }

    fun getAllInstrumento(): List<Instrumento> {
        return database.instrumentoDao().getAll()
    }

    fun getAllInstrumentoByTipoId(id: Long): List<Instrumento> {
        return database.instrumentoDao().getInstrumentosByTipoId(id)
    }


}
