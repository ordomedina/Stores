package com.example.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter(private var stores: MutableList<StoreEntity>, private var listener: OnClickListener) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

    private lateinit var mContext: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bindig = ItemStoreBinding.bind(view)

        fun setListener(storeEntity:StoreEntity){

            with(bindig.root){
                setOnClickListener{listener.onClick(storeEntity)}
                setOnLongClickListener {listener.onDeleteStore(storeEntity)
                    true  }
            }
            bindig.cbFavorite.setOnClickListener{listener.onFavoriteStore(storeEntity)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_store, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)

        with(holder){
            setListener(store)

            bindig.tvName.text = store.name
            bindig.cbFavorite.isChecked = store.isFavorite
        }
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    fun add(storeEntity: StoreEntity) {
        stores.add(storeEntity)
        notifyDataSetChanged() //El adaptador refresca toda la vista
    }

    fun setStores(stores: MutableList<StoreEntity>) {
        this.stores = stores
        notifyDataSetChanged()
    }

    fun update(storeEntity: StoreEntity) {
        val index = stores.indexOf(storeEntity)
        if(index != -1){ //El -1 significa que lo ha encontrado.
            stores.set(index, storeEntity)
            notifyItemChanged(index) //Refresca solamente el item que se ha actualizado.
        }
    }

    fun delete(storeEntity: StoreEntity) {
        val index = stores.indexOf(storeEntity)
        if(index != -1){ //El -1 significa que lo ha encontrado.
            stores.removeAt(index)
            notifyItemRemoved(index) //Refresca solamente el item que se ha eliminado.
        }
    }
}