package com.latihanbyrg.tugaspertemuan10


import androidx.annotation.DrawableRes

data class Mahasiswa(
    val name: String ="",
    val nim: String ="",
    val ipk: Double = 0.0,
    @DrawableRes val drawableId: Int = R.drawable.profil_default
)
