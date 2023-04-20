package com.devsphere.yourmoney.components.charts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDayOfWeek
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.devsphere.yourmoney.utils.simplifyNumber
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import java.time.DayOfWeek

@Composable
fun WeeklyChart(expenses: List<Expense>) {
    val groupedExpenses = expenses.groupedByDayOfWeek()

    BarChart(
        barChartData = BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = DayOfWeek.MONDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.MONDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.TUESDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.TUESDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.WEDNESDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.WEDNESDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.THURSDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.THURSDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.FRIDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.FRIDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.SATURDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.SATURDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.SUNDAY.name.substring(0, 1),
                    value = groupedExpenses[DayOfWeek.SUNDAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White,
                ),
            )
        ),
        labelDrawer = LabelDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(
            labelTextColor = LabelSecondary,
            labelValueFormatter = ::simplifyNumber,
            labelTextSize = 14.sp
        ),
        barDrawer = BarDrawer(),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxSize()
    )
}