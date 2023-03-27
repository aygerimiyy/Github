package com.example.github.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.data.models.RepositoryResponse
import com.example.github.data.models.ResultData
import com.example.github.data.models.UserResponse
import com.example.github.domain.MainRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class SearchViewModel(private val repo: MainRepository) : ViewModel() {

    val searchUsersByUsernameFlow = MutableSharedFlow<List<UserResponse>>()
    val searchRepositoriesByRepositoryNameFlow =
        MutableSharedFlow<List<RepositoryResponse>>()
    val messageFlow = MutableSharedFlow<String>()
    val errorFlow = MutableSharedFlow<Throwable>()


    suspend fun searchUserByUsername(login: String) {
        repo.searchRepositoriesByRepositoryName(login).onEach {
            when (it) {
                is ResultData.Success -> {
                    searchRepositoriesByRepositoryNameFlow.emit(it.data)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error -> {
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }

    suspend fun searchRepositoriesByRepositoryName(name: String) {
        repo.searchRepositoriesByRepositoryName(name).onEach {
            when (it) {
                is ResultData.Success -> {
                    searchRepositoriesByRepositoryNameFlow.emit(it.data)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error -> {
                    errorFlow.emit(it.error)
                }
            }
        }.launchIn(viewModelScope)
    }
}