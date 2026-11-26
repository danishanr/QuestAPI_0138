package com.example.questapi_0138.view

import android.net.http.HttpException
import androidx.compose.runtime.mutableStateOf
import com.example.questapi_0138.modeldata.DataSiswa
import com.example.questapi_0138.repositori.RepositoryDataSiswa
import java.io.IOException
import java.util.Collections.list

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<DataSiswa> = listOf()) :
            StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    val listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa
        .Loading)
        private set

    init {
        loadSiswa()
    }

    fun loadSiswa(){
        viewModelScope.launch {
            list = StatusUiSiswa.Loading
            listSiswa = try {
                StatusUiSiswa.Success(repositoryDataSiswa.getDataSiswa
                    ())
            } catch (e: IOException){
                StatusUiSiswa.Error
            } catch (e: HttpException) {
                StatusUiSiswa.Error
            } catch (e: Exception) {
                StatusUiSiswa.Error
            }
        }
    }

}