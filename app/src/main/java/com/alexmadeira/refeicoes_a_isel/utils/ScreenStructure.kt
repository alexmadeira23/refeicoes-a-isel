package com.alexmadeira.refeicoes_a_isel.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ScreenStructure(
    title: String,
    body: @Composable () -> Unit,
    footer: @Composable () -> Unit = { }
) {
    Content {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 2.0f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = title, fontSize = 30.sp)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 8.0f),
                contentAlignment = Alignment.Center
            ) { body() }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 1.0f),
                contentAlignment = Alignment.Center
            ) {
                footer()
            }
        }
    }
}