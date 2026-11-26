package com.example.questapi_0138.viewmodel

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi_0138.repositori.AplikasiDataSiswa

fun CreationExtras.aplikasiDataSiswa():AplikasiDataSiswa = (
        this[ViewModelProvider.AnroidViewModelFactory.APPLICATION_KEY]
            as AplikasiDataSiswa
        )
object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container
            .repostoryDataSiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container
            .repositoryDataSiswa) }
    }
}