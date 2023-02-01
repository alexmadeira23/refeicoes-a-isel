package com.alexmadeira.refeicoes_a_isel.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexmadeira.refeicoes_a_isel.R
import com.alexmadeira.refeicoes_a_isel.utils.ScreenStructure

private const val TITLE = "Refeições À ISEL"
private const val MEALS = "Ver Pratos"
private const val DEVELOPED_BY = "Developed by Alexandre Madeira"
@Composable
fun TitleScreen(navigate: () -> Unit = { }) {
    ScreenStructure(
        title = TITLE,
        body = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.food),
                    contentDescription = "Food",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(size = 350.dp)
                        .clip(shape = RoundedCornerShape(30.dp))
                        .clickable(onClick = navigate)
                )
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(paddingValues = PaddingValues(top = 300.dp))
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = Color(0x77000000)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = MEALS,
                        fontSize = 25.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        },
        footer = { Text(text = DEVELOPED_BY) }
    )
}

@Preview
@Composable
fun TitleScreenPrev() {
    TitleScreen()
}