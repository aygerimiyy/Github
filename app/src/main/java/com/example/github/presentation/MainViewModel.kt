package com.example.github.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.data.models.GetUserProfileInfo
import com.example.github.data.models.RepositoryResponse
import com.example.github.data.models.ResultData
import com.example.github.data.models.TokenResponseData
import com.example.github.domain.MainRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(private val repo: MainRepository): ViewModel() {

    val getUserProfileFlow = MutableSharedFlow<GetUserProfileInfo>()
    val getUserRepositoriesFlow = MutableSharedFlow<List<RepositoryResponse>>()
    val getAccessTokenFlow = MutableSharedFlow<TokenResponseData>()
    val messageFlow = MutableSharedFlow<String>()
    val errorFlow = MutableSharedFlow<Throwable>()

    suspend fun getUserProfileInfo(){
        repo.getUserProfileInfo().onEach {
            when(it){
                is ResultData.Success -> {
                    getUserProfileFlow.emit(it.data)
                }
                is ResultData.Message ->{
                    messageFlow.emit(it.message)
                }
                is ResultData.Error ->{
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }

    suspend fun getUserRepositories(){
        repo.getUserRepositories().onEach {
            when(it){
                is ResultData.Success ->{
                    getUserRepositoriesFlow.emit(it.data)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error ->{
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }
    suspend fun getAccessToken(code: String){
        repo.getAccessToken(code).onEach {
            when(it){
                is ResultData.Success ->{
                    getAccessTokenFlow.emit(it.data)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error ->{
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }
}