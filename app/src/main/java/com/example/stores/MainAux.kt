package com.example.stores

//ContendrĂ¡ eventos auxiliares para el fragmento
interface MainAux {
    fun hideFab(isVisible: Boolean = false)
    fun addStore(storeEntity: StoreEntity)
    fun updateStore(storeEntity: StoreEntity)
}