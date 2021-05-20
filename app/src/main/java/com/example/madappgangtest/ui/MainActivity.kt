package com.example.madappgangtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madappgangtest.R
import com.example.madappgangtest.network.DragonRequest

class MainActivity : AppCompatActivity() {
    val dragonRequest = DragonRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dragonRequest.getAllDragonList { dragonList ->

        }

        dragonRequest.loadAllDragonList { dragonList ->
            if (dragonList == null) return@loadAllDragonList
            val adapter = DragonListAdapter(dragonList)
                /*
                init RecyclerView
                init Adapter
                передаешь в адаптер список Dragons (например ...Adapter(it)  )
                для адаптера создаешь элемент layout в котором будешь отображать данные по ракете
                подставляешь данные с полученного объекта Dragon в layout для отображения на экране =)
                 */
        }
    }
}