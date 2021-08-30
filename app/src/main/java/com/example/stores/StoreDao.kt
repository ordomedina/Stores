package com.example.stores

import androidx.room.*
//Aquí definiremos las distintas consultas
@Dao
interface StoreDao {

    @Query("SELECT * FROM StoreEntity")
    fun getAllStores() : MutableList<StoreEntity>

    @Insert
    fun addStore(storeEntity: StoreEntity): Long //Nos va a devolver el identificador del registro recién creado.

    @Update
    fun updateStore(storeEntity: StoreEntity)

    @Delete
    fun deleteStore(storeEntity: StoreEntity)


}