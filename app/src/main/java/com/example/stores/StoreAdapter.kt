package com.example.stores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bindig = ItemStoreBinding.bind(view)
    }
}