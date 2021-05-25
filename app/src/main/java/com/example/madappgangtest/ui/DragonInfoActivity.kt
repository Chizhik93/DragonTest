package com.example.madappgangtest.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madappgangtest.R
import com.example.madappgangtest.network.DragonRequest


class DragonInfoActivity : AppCompatActivity() {
    private lateinit var dragonRequest: DragonRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_info)
        val intent = intent
        val dragonId = intent.getStringExtra("dragonId") ?: ""
        dragonRequest = DragonRequest(applicationContext)
        val dragon = dragonRequest.getDragonById(dragonId)

        val dragonTitle = findViewById<TextView>(R.id.infoTitleText)
        dragonTitle.text = dragon.name
        val infoDescriptionText = findViewById<TextView>(R.id.infoDescriptionText)
        infoDescriptionText.text = dragon.description
        val infoWikiText = findViewById<TextView>(R.id.infoWikiText)
        infoWikiText.text = "WiKi: ${dragon.wikipidia}"
        val infoMassText = findViewById<TextView>(R.id.infoMassText)
        infoMassText.text = "Mass: ${dragon.dryMassKg} kg"
        val infoFlightText = findViewById<TextView>(R.id.infoFlightText)
        infoFlightText.text = "First flight: ${dragon.firstFlight}"
        val infoDiameterText = findViewById<TextView>(R.id.infoDiameterText)
        infoDiameterText.text = "Diameter: ${dragon.diameter.metersDiameter} m"

        val dragonItems = findViewById<RecyclerView>(R.id.infoRecyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        dragonItems.layoutManager = linearLayoutManager

        val adapter = DragonPhotosAdapter(dragon.flickrImages.toMutableList())
        dragonItems.adapter = adapter

    }
}