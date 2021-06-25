package com.surgatutorial.latihanrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.surgatutorial.latihanrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val listFoods = listOf(
            Food(name = "Ayam Cabe Bumbu Kemangi","40 menit", image = R.drawable.ayam_cabe),
            Food(name = "Getuk Gulung Keju","45 menit", image = R.drawable.getuk),
            Food(name = "Ikan Krispi dengan Saus Santan Pedas","30 menit", image = R.drawable.ikan_krispy),
            Food(name = "Kare Ayam Krispi","50 menit", image = R.drawable.kare_ayam),
            Food(name = "Es Krim Kelapa dengan Cherry & Almon","25 menit", image = R.drawable.es_krim),
            Food(name = "Plecing Ayam","45 menit", image = R.drawable.plecing),
            Food(name = "Sayur Labu Udang","40 menit", image = R.drawable.sayur_labu),
            Food(name = "Udang Paprika Sambal","30 menit", image = R.drawable.udang),
            Food(name = "Udang Panggang Saus Peri-Peri","30 menit", image = R.drawable.udang_panggang),
            Food(name = "Daging Pedas Ala Thailand","30 menit", image = R.drawable.daging_pedas)
        )

        val foodsAdapter = FoodAdapter(listFoods)

        bind.rvMain.setHasFixedSize(true)
        bind.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = foodsAdapter
        }
        foodsAdapter.setOnItemClickCallback(object : FoodAdapter.OnItemClickCallback{
            override fun onItemClicked(food: Food) {
                Toast.makeText(this@MainActivity, "${food.name} di pilih", Toast.LENGTH_SHORT).show()
            }
        })

    }
}