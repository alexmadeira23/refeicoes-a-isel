package com.alexmadeira.refeicoes_a_isel.food

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmadeira.refeicoes_a_isel.utils.getWeekDayName
import com.alexmadeira.refeicoes_a_isel.utils.send
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jsoup.Jsoup
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class FoodViewModel(private val httpClient: OkHttpClient) : ViewModel() {

    companion object {
        private const val BASE_URL =
            "https://www.sas.ipl.pt/ementa/Instituto%20Superior%20de%20Engenharia%20de%20Lisboa/196/"

        private const val FOOD_PATH_TEMPLATE =
            "%20{fromDay}%20de%20{fromMonth}%20a%20{toDay}%20de%20{toMonth}%20de%20{year}"

        private const val FOOTER_SELECTOR = "footer"
        private const val HEADER_SELECTOR = "header"
        private const val FOOD_OPTION_SELECTOR = ".dia-semana-ementa"
        private const val FOOD_SELECTOR = ".title"
        private const val FOOD_TYPE_SELECTOR = ".field--name-field-tipo-de-prato"
        private const val SPAN_SELECTOR = "span"
        private const val A_SELECTOR = "a"
    }

    private var _foods by mutableStateOf<List<Food>?>(value = null)

    val foods get() = _foods

    fun getFoods() {
        viewModelScope.launch {
            _foods = requestFoods()
        }
    }

    private suspend fun requestFoods(): List<Food> {
        return Request
            .Builder()
            .url(BASE_URL + getWeeksPath())
            .build()
            .send(httpClient) { res -> handleResponse(res) }
    }

    private fun handleResponse(res: Response): List<Food> {
        val body = res.body?.string() ?: throw Exception()
        val html = Jsoup.parse(body)

        val weekFoodsHtml = html.selectFirst(FOOTER_SELECTOR)
            ?: return emptyList()

        val dayHtml = weekFoodsHtml.children().find {
            it.selectFirst(HEADER_SELECTOR)?.text() == getWeekDayName()
        } ?: return emptyList()

        return dayHtml.select(FOOD_OPTION_SELECTOR).map { availableFoods ->
            val readFood = availableFoods
                .selectFirst(FOOD_SELECTOR)
                ?.selectFirst(SPAN_SELECTOR)
                ?.selectFirst(A_SELECTOR)
                ?.text() ?: return emptyList()
            val readFoodType = availableFoods
                .selectFirst(FOOD_TYPE_SELECTOR)
                ?.selectFirst(A_SELECTOR)
                ?.text() ?: return emptyList()
            Food(type = readFoodType, food = readFood)
        }
    }

    private fun getWeeksPath(): String {
        val today = LocalDate.now()

        val lastMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))
        val fromDay = lastMonday.dayOfMonth
        val fromMonth = lastMonday.month

        val nextFriday = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
        val toDay = nextFriday.dayOfMonth
        val toMonth = nextFriday.month

        val year = today.year

        return FOOD_PATH_TEMPLATE
            .replace("{fromDay}", fromDay.toString())
            .replace("{fromMonth}", fromMonth.toString())
            .replace("{toDay}", toDay.toString())
            .replace("{toMonth}", toMonth.toString())
            .replace("{year}", year.toString())
    }
}