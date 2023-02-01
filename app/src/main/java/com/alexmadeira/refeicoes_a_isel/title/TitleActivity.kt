package com.alexmadeira.refeicoes_a_isel.title

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alexmadeira.refeicoes_a_isel.food.FoodActivity

class TitleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitleScreen {
                FoodActivity.navigate(origin = this)
            }
        }
    }
}