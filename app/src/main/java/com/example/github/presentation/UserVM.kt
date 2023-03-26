package com.example.github.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.ApiInterface
import com.example.github.data.models.UserResponse
import com.example.github.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class UserVM(private val api: ApiInterface): ViewModel() {
    private var mutableUser = MutableLiveData<Resource<UserResponse>>()
    val user = mutableUser

    val token = "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"
/*
    fun user(){
        mutableUser.value = Resource.loading()
        viewModelScope.launch {
            try {
                val response = api.user("2023-03-26", token)
                if (response.isSuccessful) {
                    mutableUser.value = Resource.success(response.body()!!)
                } else {
                    mutableUser.value = Resource.error(response.message())
                }
            } catch (e: IOException) {
                mutableUser.value = Resource.error(e.message)
            } catch (e: HttpException) {
                mutableUser.value = Resource.error(e.message)
            } catch (e: Exception) {
                mutableUser.value = Resource.error(e.message)
            }
        }
    }*/
}