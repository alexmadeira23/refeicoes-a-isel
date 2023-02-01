package com.alexmadeira.refeicoes_a_isel.food

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.alexmadeira.refeicoes_a_isel.HttpClient
import com.alexmadeira.refeicoes_a_isel.utils.viewModelInit

class FoodActivity : ComponentActivity() {

    companion object {
        fun navigate(origin: Activity) {
            with(origin) {
                val intent = Intent(this, FoodActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private val httpClient by lazy { application as HttpClient }

    private val viewModel: FoodViewModel by viewModels {
        viewModelInit { FoodViewModel(httpClient = httpClient.httpClient) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.foods == null)
            viewModel.getFoods()
        setContent {
            FoodScreen(viewModel.foods)
        }
    }
}