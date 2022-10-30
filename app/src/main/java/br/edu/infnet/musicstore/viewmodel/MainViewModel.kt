package br.edu.infnet.musicstore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.infnet.musicstore.models.Tipo
import br.edu.infnet.musicstore.models.Instrumento
import br.edu.infnet.musicstore.repositories.StoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val repositorio = StoreRepository.get()

    // Tipo:

    fun insertTipo(tipo: Tipo) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.insertTipo(tipo)
        }
    }

    suspend fun getTipoById(id: Long) : Tipo {
        val tipo = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getTipoById(id)
        }
        return tipo.await()
    }

    fun deleteTipoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.deleteTipo(Tipo(id = id))
        }
    }

    fun updateTipo(tipo: Tipo){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.updateTipo(tipo)
        }
    }

    suspend fun getAllTipo(): List<Tipo> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllTipo()
        }
        return lista.await()
    }

    suspend fun getAllTiposString(): String{
        val lista = getAllTipo()
        var texto = ""

        lista.forEach {
            texto += "${it.id} ${it.nome}\n"
        }
        return texto
    }

    // Instrumento:

    fun insertInstrumento(instrumento: Instrumento) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.insertInstrumento(instrumento)
        }
    }

    suspend fun getInstrumentoById(id: Long) : Instrumento {
        val instrumento = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getInstrumentoById(id)
        }
        return instrumento.await()
    }

    fun deleteInstrumentoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO){
            repositorio.deleteInstrumento(Instrumento(id = id))
        }
    }

    fun updateInstrumento(instrumento: Instrumento){
        viewModelScope.launch(Dispatchers.IO){
            repositorio.updateInstrumento(instrumento)
        }
    }

    suspend fun getAllInstrumentos(): List<Instrumento> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllInstrumento()
        }
        return lista.await()
    }

    suspend fun getInstrumentoByTipoId(id: Long): List<Instrumento> {
        val lista = viewModelScope.async(Dispatchers.IO){
            return@async repositorio.getAllInstrumentoByTipoId(id)
        }
        return lista.await()
    }


    suspend fun getAllInstrumentosString(): String{
        val lista = getAllInstrumentos()
        var texto = ""

        lista.forEach {
            texto += "${it.id} ${it.nome} - TipoId: ${it.tipoId}\n"
        }
        return texto
    }

}