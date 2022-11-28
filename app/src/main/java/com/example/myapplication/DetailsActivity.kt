package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.databinding.ActivityDetailsBinding
import de.hdodenhof.circleimageview.CircleImageView

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //bundle init
        val bundle : Bundle = intent.extras!!
        val nama_karakter = bundle.getString("namaWaifu")
        val penjelasan_karakter = bundle.getString("detailWaifu")
        val imageId = bundle.getInt("fotoWaifu")
        val namaSenjataGenshin = bundle.getString("namaSenjata")
        val fotoSenjataGenshin = bundle.getInt("fotoSenjata")


        binding.detailsNama.text = nama_karakter
        binding.detailsPenjelasan.text = penjelasan_karakter
        binding.detailsPhoto.setImageResource(imageId)
        binding.PamerSenjata.text = namaSenjataGenshin
        binding.imageSenjata.setImageResource(fotoSenjataGenshin)

        binding.backMainMenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}