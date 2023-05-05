package com.devsphere.yourmoney.components.mock

import androidx.compose.ui.graphics.Color
import com.devsphere.yourmoney.models.Category
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.Recurrence
import io.github.serpro69.kfaker.Faker
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

val faker = Faker()

val mockCategories = listOf(
    Category(
        "Bills",
        Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
        )
    ),
    Category(
        "Fruits",
        Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
        )
    ),
    Category(
        "Vegetables",
        Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
        )
    ),
    Category(
        "Subscriptions",
        Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
        ),
    )
)

val mockExpenses: List<Expense> = List(30) { index ->
    Expense(
        id = index,
        amount = faker.random.nextInt(min = 100, max = 1000000).toDouble() + faker.random.nextDouble(),
        date = LocalDateTime.now().minus(
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
        note = faker.backToTheFuture.characters(),
        category = faker.random.randomValue(mockCategories)
    )
}