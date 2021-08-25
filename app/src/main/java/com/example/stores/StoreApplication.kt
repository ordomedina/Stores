package com.example.stores

import android.app.Application
import androidx.room.Room

class StoreApplication: Application() {
    companion object { // la palabra reservada object nos va a configurar el patrón sigleton,
        // y companion va a hacer accesible esto desde cualquier punto de nuestra aplicación
        lateinit var database: StoreDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, StoreDatabase::class.java, "StoreDatabase").build()
    }
}