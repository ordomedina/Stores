package com.example.stores

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class StoreApplication: Application() {
    companion object { // la palabra reservada object nos va a configurar el patrón sigleton,
        // y companion va a hacer accesible esto desde cualquier punto de nuestra aplicación
        lateinit var database: StoreDatabase
    }

    override fun onCreate() {
        super.onCreate()

        val MIGRATION_1_2 = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE StoreEntity ADD COLUMN photoUrl TEXT NOT NULL DEFAULT ''")
            }
        }

        database = Room.databaseBuilder(this, StoreDatabase::class.java, "StoreDatabase")
            .addMigrations(MIGRATION_1_2)
            .build()
    }
}