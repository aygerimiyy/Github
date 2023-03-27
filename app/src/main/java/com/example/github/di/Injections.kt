package com.example.github.di

import com.example.github.data.remote.ApiInterface
import com.example.github.domain.MainRepository
import com.example.github.presentation.MainViewModel
import com.example.github.presentation.SearchViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        MainRepository(api = get())
    }

    single<Retrofit> {
        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )

        val interceptor = GithubInterceptor()

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com").client(client).build()
        retrofit
    }
    single {
        provideApi(retrofit = get())
    }
}
    val viewModelModule = module {
        single {
            MainViewModel(repo = get())
        }

        single {
            SearchViewModel(repo = get())
        }
    }

    fun provideApi(retrofit: Retrofit): ApiInterface{
        return retrofit.create(ApiInterface::class.java)

}


