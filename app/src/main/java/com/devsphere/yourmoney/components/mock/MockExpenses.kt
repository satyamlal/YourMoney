package com.devsphere.yourmoney.components.mock

import androidx.compose.ui.graphics.Color
import com.devsphere.yourmoney.models.Category
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.Recurrence
import io.github.serpro69.kfaker.Faker
import java.time.LocalDate
import java.time.temporal.ChronoUnit

val faker = Faker()

val mockExpenses: List<Expense> = List(30) {index ->
    Expense(
        id = index,
        amount = faker.random.nextInt(min = 1, max = 999).toDouble(),
        date = LocalDate.now().minus(
            faker.random.nextInt(min = 300, max = 345600).toLong(),
            ChronoUnit.SECONDS
        ),
        recurrence = faker.random.randomValue(
            listOf(
                Recurrence.None,
                Recurrence.Daily,
                Recurrence.Weekly,
                Recurrence.Monthly,
                Recurrence.Yearly
            )
        ),
        note = faker.australia.animals(),
        category = faker.random.randomValue(
            listOf(
                Category("Bills", Color.Red),
                Category("Fruits", Color.Yellow),
                Category("Vegetables", Color.White),
                Category("Subscriptions", Color.Green),
            )
        )
    )
}