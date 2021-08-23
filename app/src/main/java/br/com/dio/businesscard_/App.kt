package br.com.dio.businesscard_

import android.app.Application
import br.com.dio.businesscard_.data.AppDatabase
import br.com.dio.businesscard_.data.BusinessCardRepository

//gerenciamento de repositorios, roda antes da main activity
//classe inicializadora da aplicação q esta como name no Android Manifest

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}