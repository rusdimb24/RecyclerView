package com.rusdimaulana.recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rusdimaulana.recycle_view.adapter.AdapterTeamBola
import com.rusdimaulana.recycle_view.databinding.ActivityMainBinding
import com.rusdimaulana.recycle_view.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Genzo Wakabayashi",R.drawable.wakabayashi,"Kiper","190 CM", "Tokyo", "27 Februari 1998"))
        listPemain.add(Pemain("Hiroshi Jito",R.drawable.jito,"Bek","185 CM", "Saitama", "15 Januari 1998"))
        listPemain.add(Pemain("Taro Misaki",R.drawable.misaki,"Gelandang","182 CM", "Narita", "07 Agustus 1999"))
        listPemain.add(Pemain("Tsubasa Ozora",R.drawable.tsubasa,"Gelandang","181 CM", "Tokyo", "24 November 1999"))
        listPemain.add(Pemain("Kojiro Hyuga",R.drawable.hyuga,"Penyerang","184 CM", "Osaka", "28 Desember 1998"))

        binding.list.adapter = AdapterTeamBola(this, listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }
        })
    }

}