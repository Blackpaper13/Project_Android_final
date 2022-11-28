package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var listAllWaifu: ArrayList<Waifu> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHeroesWaifu.setHasFixedSize(true)
        listAllWaifu.addAll(waifuObject.listData)
        showRecyclerList()

        binding.aboutButton.setOnClickListener{
            val intent = Intent(applicationContext, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecyclerList() {
        binding.rvHeroesWaifu.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterWaifu(listAllWaifu)
        binding.rvHeroesWaifu.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterWaifu.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("namaWaifu", listAllWaifu[position].nama_waifu)
                intent.putExtra("detailWaifu", listAllWaifu[position].detail_waifu)
                intent.putExtra("fotoWaifu",listAllWaifu[position].photo_waifu)
                intent.putExtra("namaSenjata", listAllWaifu[position].nama_senjata)
                intent.putExtra("fotoSenjata", listAllWaifu[position].foto_senjata)
                startActivity(intent)

                showMessage("Anda menclick no $position")
            }

        })

    }

    private fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }


}