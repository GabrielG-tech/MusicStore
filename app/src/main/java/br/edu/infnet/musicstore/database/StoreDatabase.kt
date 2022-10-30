package br.edu.infnet.musicstore.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.infnet.musicstore.daos.InstrumentoDao
import br.edu.infnet.musicstore.daos.TipoDao
import br.edu.infnet.musicstore.models.Tipo
import br.edu.infnet.musicstore.models.Instrumento


@Database(entities = [Tipo::class, Instrumento::class], version = 1, exportSchema = false)

abstract class StoreDatabase: RoomDatabase() {
    abstract fun tipoDao(): TipoDao
    abstract fun instrumentoDao(): InstrumentoDao
}
