package com.alexmadeira.refeicoes_a_isel.food

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexmadeira.refeicoes_a_isel.utils.ScreenStructure
import com.alexmadeira.refeicoes_a_isel.utils.getWeekDayName

const val LOADING = "Consultando o chefe..."

@Composable
fun FoodScreen(foods: List<Food>? = null) {
    ScreenStructure(
        title = getWeekDayName(),
        body = {
            if (foods != null) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    for (food in foods) {
                        Column(modifier = Modifier.width(250.dp)) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = food.type,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = food.food,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            } else {
                Text(
                    text = LOADING,
                    fontSize = 30.sp
                )
            }
        }
    )
}

@Preview
@Composable
fun FoodScreenPrev() {
    FoodScreen()
}