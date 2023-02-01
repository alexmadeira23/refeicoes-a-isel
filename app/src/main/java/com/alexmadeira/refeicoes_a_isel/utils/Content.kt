package com.alexmadeira.refeicoes_a_isel.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexmadeira.refeicoes_a_isel.ui.theme.RefeicoesAIselTheme

@Composable
fun Content(content: @Composable () -> Unit) {
    RefeicoesAIselTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}