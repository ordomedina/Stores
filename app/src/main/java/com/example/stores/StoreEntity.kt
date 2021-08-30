package com.example.stores

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StoreEntity")
data class StoreEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0, //El id le hemos indicado que se autogenere solo.
                       var name: String,
                       var phone: String,
                       var website: String = "",
                       var photoUrl: String,
                       var isFavorite: Boolean = false)
