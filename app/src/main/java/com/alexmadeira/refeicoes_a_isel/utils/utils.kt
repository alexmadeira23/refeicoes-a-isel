package com.alexmadeira.refeicoes_a_isel.utils

import java.time.DayOfWeek
import java.time.LocalDate

fun getWeekDayName(): String {
    val today = LocalDate.now()
    val weekDay = today.dayOfWeek ?: throw IllegalStateException()

    return when (weekDay) {
        DayOfWeek.MONDAY -> "Segunda-Feira"
        DayOfWeek.TUESDAY -> "Terça-Feira"
        DayOfWeek.WEDNESDAY -> "Quarta-Feira"
        DayOfWeek.THURSDAY -> "Quinta-Feira"
        DayOfWeek.FRIDAY -> "Sexta-Feira"
        DayOfWeek.SATURDAY -> "Sábado"
        DayOfWeek.SUNDAY -> "Domingo"
    }
}