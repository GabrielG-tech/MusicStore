package br.edu.infnet.musicstore.application

import android.app.Application
import br.edu.infnet.musicstore.repositories.StoreRepository

class StoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        StoreRepository.initialize(this)
    }
}
