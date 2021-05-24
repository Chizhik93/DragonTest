package com.example.madappgangtest.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madappgangtest.R
import com.example.madappgangtest.network.DragonRequest


class MainActivity : AppCompatActivity() {
    private lateinit var dragonRequest:DragonRequest

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dragonRequest = DragonRequest(applicationContext)

        val dragonItems = findViewById<RecyclerView>(R.id.rcView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        dragonItems.layoutManager = linearLayoutManager

        val dragonList = dragonRequest.getAllDragonList()
        val adapter = DragonListAdapter(dragonList, onDragonClick = { dragon ->
            showInfoScreen(dragon.id)
        })
        dragonItems.adapter = adapter

        dragonRequest.loadAllDragonList {
            if (it == null) return@loadAllDragonList
            adapter.dragonList = it
            adapter.notifyDataSetChanged()

                /*
                init RecyclerView
                init Adapter
                передаешь в адаптер список Dragons (например ...Adapter(it)  )
                для адаптера создаешь элемент layout в котором будешь отображать данные по ракете
                подставляешь данные с полученного объекта Dragon в layout для отображения на экране =)
                 */

        }

    }

    fun showInfoScreen(dragonId: String) {
        val myIntent = Intent(this, DragonInfoActivity::class.java)
        myIntent.putExtra("dragonId", dragonId)
        startActivity(myIntent)
    }
}