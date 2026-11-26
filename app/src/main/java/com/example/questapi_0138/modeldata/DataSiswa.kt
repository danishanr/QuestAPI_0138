package com.example.questapi_0138.modeldata

import kotlinx.serialization.Serializer

@Serializer
data class DataSiswa(
    val id : Int,
    val nama : String,
    val alamat : String,
    val telpon : String
)