package com.narwangunawan.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.narwangunawan.recyclerview.adapter.AdapterHewan
import com.narwangunawan.recyclerview.databinding.ActivityMainBinding
import com.narwangunawan.recyclerview.model.Hewan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listHewan = ArrayList<Hewan>()
        listHewan.add(Hewan("Kucing Domestik",R.drawable.kucing,"Felis silvestris catus","Mammalia","Felidae","Carnivora"))
        listHewan.add(Hewan("Panda",R.drawable.panda,"Ailuropoda Melanoleuca","Mammalia","Ursidae","Carnivora"))
        listHewan.add(Hewan("Badak",R.drawable.badak,"Rhinoceros Sondaicus","Mammalia","Rhinocerotidae","Perissodactyla"))
        listHewan.add(Hewan("Kanguru",R.drawable.kanguru,"Makropoda","Mammalia","Macropodidae","Diprotodontia"))
        listHewan.add(Hewan("Jerapah",R.drawable.jerapah,"Giraffa camelopardalis","Mammalia","Giraffidae","Artiodactyla"))
        listHewan.add(Hewan("Kelinci",R.drawable.kelinci,"Oryctolagus cuniculus","Mammalia","Leporidae","Lagomorpha"))
        listHewan.add(Hewan("Sapi",R.drawable.sapi,"Bos taurus","Mammalia","Bovidae","Artiodactyla"))
        listHewan.add(Hewan("Gajah",R.drawable.gajah,"Loxodonta","Mammalia","Elephantidae","Proboscidea"))
        listHewan.add(Hewan("Kuda",R.drawable.kuda,"Equus caballus","Mammalia","Equidae","Perissodactyla"))
        listHewan.add(Hewan("Harimau",R.drawable.harimau,"Panthera tigris","Mammalia","Felidae","Carnivora"))

        binding.list.adapter = AdapterHewan(this,listHewan,object : AdapterHewan.OnClickListener {
            override fun detailData(item: Hewan?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_hewan)

                    val image = this.findViewById<ImageView>(R.id.image_hewan)
                    val nama = this.findViewById<TextView>(R.id.txtNamaHewan)


                    val ilmiah = this.findViewById<TextView>(R.id.txtnamailmiah)
                    val jenis = this.findViewById<TextView>(R.id.txtJenisHewan)
                    val keluarga = this.findViewById<TextView>(R.id.txtKeluarga)
                    val ordo = this.findViewById<TextView>(R.id.txtOrdo)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    ilmiah.text = "${item?.ilmiah}"
                    jenis.text = "${item?.jenis}"
                    keluarga.text = "${item?.keluarga}"
                    ordo.text = "${item?.ordo}"

                    btn.setOnClickListener {
                        this.dismiss()


                    }


                }.show()
            }

        })


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent (this, Profile::class.java)
                startActivity(intent)
            }
        }
    }
}