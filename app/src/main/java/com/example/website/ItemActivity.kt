package com.example.website

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razorpay.Checkout

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)



        val listWeapons = findViewById<RecyclerView>(R.id.goods_item)
        val weapons = arrayListOf<Weapons>()
        weapons.add(Weapons(1, "mp155", "Shotgun MP-155",
            "Caliber 12/76","An excellent rifle for hunting and self-defense\nСartridge capacity - 4", 1600))
        weapons.add(Weapons(2, "sayga12", "Shotgun Sayga-12",
            "Caliber 12/76","An excellent rifle for hunting, self-defense and sport\n" +
                    "Сartridge capacity - 8", 2500))
        weapons.add(Weapons(3, "vepr12", "Shotgun Vepr-12SP",
            "Caliber 12/76","An excellent rifle for hunting and self-defense or sport\n" +
                    "Сartridge capacity - 10", 5400))

        listWeapons.layoutManager = LinearLayoutManager(this)
        listWeapons.adapter = ItemsAdapter(weapons, this)

    }
}