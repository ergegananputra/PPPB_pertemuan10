package com.latihanbyrg.tugaspertemuan10

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihanbyrg.tugaspertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Full Screen Window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        } else {
            // Deprecated API BELOW 30
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))




        with(binding) {
            rvMahasiswa.apply {
                adapter = MahasiswaAdapter(
                    listMahasiswa = generateMahasiswa(),
                    onClickMahasiswa = {
                        mahasiswa ->

                        val randomString = listOf(
                            "baik!",
                            "cakep!",
                            "pintar!",
                            "rajin!"
                        ).random()
                        Toast.makeText(this@MainActivity, "${mahasiswa.name} itu $randomString", Toast.LENGTH_SHORT).show()
                        Log.d("MainActivity", "${mahasiswa.name} itu $randomString")

                    }

                )
                layoutManager = LinearLayoutManager(this@MainActivity)
            }



        }


    }



    fun generateMahasiswa() : List<Mahasiswa> {
        return listOf(
            Mahasiswa("Adiel Boanerge G", "22/500051/SV/21386", 4.0, R.drawable.img12),
            Mahasiswa("Sena Aji Bayu M", "22/500149/SV/56732", 3.8, R.drawable.img10),
            Mahasiswa("Rizky Fauzan", "22/500150/SV/24323", 3.0, R.drawable.img1),
            Mahasiswa("Devrangga Ranggo Tambudi", "22/498784/SV/13468", 3.0, R.drawable.img11),
            Mahasiswa("Ashila Najla Salsabila WD", "22/500151/SV/142353", 3.5, R.drawable.img3),
            Mahasiswa("Hirzi Saltono Hartono", "22/491232/SV/12335", 3.7, R.drawable.img2),
            Mahasiswa("Muhammad Rizky F", "22/500152/SV/12345", 3.0, R.drawable.img4),
            Mahasiswa("Mahesa Nugraha", "22/493981/SV/20767", 4.0, R.drawable.img5),
            Mahasiswa("Kristiano Gonzales", "22/490153/SV/100213", 3.9, R.drawable.img6),
            Mahasiswa("Kinanto Cahyabuana", "22/429820/SV/222222", 3.3, R.drawable.img7),
            Mahasiswa("Segara Nusantara", "22/498001/SV/245711", 2.7, R.drawable.img8),
            Mahasiswa("Irene Sang Mentari Senja", "22/489056/SV/111123", 3.2, R.drawable.img9),



        )

    }



}