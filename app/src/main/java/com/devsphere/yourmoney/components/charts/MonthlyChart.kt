package com.devsphere.yourmoney.components.charts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDayOfMonth
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.devsphere.yourmoney.utils.simplifyNumber
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun MonthlyChart(expenses: List<Expense>, month: LocalDate){
    val groupedExpenses = expenses.groupedByDayOfMonth()
    val numberOfDays = YearMonth.of(month.Year, month.month).lengthOfMonth()

    BarChart(
        barChartData = BarChartData(
            bars = buildList() {
                for(i in 0..numberOfDays){
                    add(
                        BarChartData.Bar(
                            label = DayOfWeek.MONDAY.name.substring(0, 1),
                            value = groupedExpenses[i]?.total?.toFloat() ?: 0f,
                            color = Color.White,
                        )
                    )
                }

            }
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