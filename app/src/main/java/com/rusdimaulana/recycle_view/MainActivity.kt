package com.rusdimaulana.recycle_view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
               Dialog(this@MainActivity).apply {
                   requestWindowFeature(Window.FEATURE_NO_TITLE)
                   setCancelable(true)
                   setContentView(R.layout.detail_data_pemain)

                   val image = this.findViewById<ImageView>(R.id.imgpemain)
                   val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                   val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                   val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                   val tempatlahir = this.findViewById<TextView>(R.id.txtTempatlahir)
                   val tanggallahir = this.findViewById<TextView>(R.id.txtTanggallahir)
                   val btn = this.findViewById<Button>(R.id.btnClose)

                   image.setImageResource(item?.foto ?:0)
                   nama.text = "${item?.nama}"
                   posisi.text = "${item?.posisi}"
                   tinggi.text = "${item?.tinggi}"
                   tempatlahir.text = "${item?.tempatlahir}"
                   tanggallahir.text = "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }

               }.show()
            }
        })
    }

}