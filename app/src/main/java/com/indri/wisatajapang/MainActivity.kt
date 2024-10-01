package com.indri.wisatajapang

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indri.wisatajapang.adapter.WisataAdapter
import com.indri.wisatajapang.model.WisataList
import com.indri.wisatajapang.model.WisataModel

class MainActivity : AppCompatActivity() {
    private lateinit var rv_wisata : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rv_wisata= findViewById(R.id.rv_wisata)

        rv_wisata.layoutManager = GridLayoutManager(this,  2)
        val adapter = WisataAdapter(WisataList.getModel() as ArrayList<WisataModel> , this)
        rv_wisata.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}