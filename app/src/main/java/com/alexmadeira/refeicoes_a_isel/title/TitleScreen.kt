package com.alexmadeira.refeicoes_a_isel.title

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexmadeira.refeicoes_a_isel.utils.Content

@Composable
fun TitleScreen(navigate: () -> Unit = { }) {
    Content {
        Button(onClick = navigate) {
            Text(text = "Go to food")
        }
    }
}

@Preview
@Composable
fun TitleScreenPrev() {
    TitleScreen()
}