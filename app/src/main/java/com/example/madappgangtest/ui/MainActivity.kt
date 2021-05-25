package com.example.madappgangtest.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.madappgangtest.R
import com.example.madappgangtest.data.Dragon
import com.example.madappgangtest.network.DragonRequest


class MainActivity : AppCompatActivity() {
    private lateinit var dragonRequest:DragonRequest
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dragonRequest = DragonRequest(applicationContext)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh)



        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val dragonItems = findViewById<RecyclerView>(R.id.rcView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        dragonItems.layoutManager = linearLayoutManager
        Thread.sleep(4000)
        val dragonList = dragonRequest.getAllDragonList()
        if(dragonList.size > 0){
            progressBar.visibility = View.GONE
        }
        val adapter = DragonListAdapter(dragonList, onDragonClick = { dragon ->
            showInfoScreen(dragon.id)
        })
        dragonItems.adapter = adapter
        fun loadDragonsFromServer(dragons: MutableList<Dragon>?) {

            progressBar.visibility = View.GONE
            if (dragons == null) return
            adapter.dragonList = dragons
            adapter.notifyDataSetChanged()
        }


        dragonRequest.loadAllDragonList {
            loadDragonsFromServer(it)
        }


        swipeRefreshLayout.setOnRefreshListener(){
                dragonRequest.loadAllDragonList {
                    loadDragonsFromServer(it)
                    swipeRefreshLayout.isRefreshing = false
            }

        }




    }

    fun showInfoScreen(dragonId: String) {
        val myIntent = Intent(this, DragonInfoActivity::class.java)
        myIntent.putExtra("dragonId", dragonId)
        startActivity(myIntent)
    }
}