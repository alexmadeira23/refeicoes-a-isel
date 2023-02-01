package com.alexmadeira.refeicoes_a_isel.food

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexmadeira.refeicoes_a_isel.utils.Content

@Composable
fun FoodScreen(foods: List<Food>? = null) {
    Content {
        if (foods != null) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (food in foods) {
                    Row {
                        Text(text = "${food.type} - ${food.food}")
                    }
                }
            }
        } else {
            Text("Consultando o chefe...")
        }
    }
}

@Preview
@Composable
fun FoodScreenPrev() {
    FoodScreen(
        listOf(
            Food(type = "Sopa", food = "Cenoura"),
            Food(type = "Veggie", food = "Alface"),
            Food(type = "Finger Food", food = "Nuggets"),
            Food(type = "Mar", food = "Tomate"),
        )
    )
}