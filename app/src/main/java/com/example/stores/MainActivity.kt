package com.example.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridlayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridlayout = GridLayoutManager(this, 2)

        mBinding.recyclerview.apply {
            setHasFixedSize(true) // Esta línea es para indicar que tiene un tamaño fijo, ya que le habíamos indicado una altura fija a cada tarjeta.
            layoutManager = mGridlayout
            adapter = mAdapter
        }
    }

    //OnClicklistener
    override fun onClick(store: Store) {

    }
}