package com.example.questapi_0138.viewmodel

import com.example.questapi_0138.repositori.RepositoryDataSiswa

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa
        .detailSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon
                .isNotBlannk()
        }
    }

    fun upadteUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detail = detailSiswa, isEntryValid =
                validasiInput(detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun addSiswa() {
        if (validasiInput()) {
            val sip:Response<Void> = repositoryDataSiswa.postDataSiswa(
                uiStateSiswa.detailSiswa.toDataSiswa())
            if (sip.isSuccessful){
                println("Sukses Tambah Data : ${sip.message()}")

            } else {
                println("Gagal tambah data : ${sip.errorBody()}")
            }
        }
    }
}

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

fun DetailSiswa.toDataSiswa(): DataSiswa = DataSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun DataSiswa.toUiStateSiswa(isEbtryValid: Boolean = false):
        UIStateSiswa = UIStateSiswa(
        detailSiswa = this.toDetailSiswa(),
        isENtryValid = isEntryValid
)

fun DataSiswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)
