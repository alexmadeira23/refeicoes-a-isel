package com.alexmadeira.refeicoes_a_isel

import android.app.Application
import okhttp3.Cache
import okhttp3.OkHttpClient

interface HttpClient {
    val httpClient: OkHttpClient
}

class RefeicoesAIselApplication : HttpClient, Application() {
    override val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .cache(Cache(directory = cacheDir, maxSize = 50 * 1024 * 1024))
            .build()
    }
}