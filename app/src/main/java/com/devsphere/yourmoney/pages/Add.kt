package com.devsphere.yourmoney.pages

import android.app.DatePickerDialog
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.components.UnstyledTextField
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.ui.theme.*
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import com.devsphere.yourmoney.viewmodels.AddViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable

fun Add(navController: NavController, vm: AddViewModel = viewModel()) {
    val state by vm.uiState.collectAsState()

    val recurrences = listOf(
        Recurrence.None,
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly,
    )

    val categories = listOf("Groceries", "Bills", "Fruits", "Vegetables")

    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH) + 1
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    var mDate by remember {
        mutableStateOf(
            "${mCalendar.get(Calendar.DAY_OF_MONTH)}-${mCalendar.get(Calendar.MONTH) + 1}-${
                mCalendar.get(
                    Calendar.YEAR
                )
            }"
        )
    }

    val mDatePicker = DatePickerDialog(
        mContext, { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            mDate = "${selectedDay}-${selectedMonth + 1}-${selectedYear}"
        }, mYear, mMonth, mDay
    )
    mDatePicker.datePicker.maxDate = mCalendar.timeInMillis

    Scaffold(topBar = {
        MediumTopAppBar(
            title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            )
        )
    }, content = { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
            ) {
                TableRow(label = "Amount", detailContent = {
                    UnstyledTextField(
                        value = state.amount,
                        onValueChange = vm::setAmount,
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),
                        placeholder = { Text("0") },
                        arrangement = Arrangement.End,
                        maxLines = 1,
                        textStyle = TextStyle(
                            textAlign = TextAlign.End,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                        )
                    )
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
                TableRow(label = "Recurrence", detailContent = {
                    var recurrenceMenuOpened by remember {
                        mutableStateOf(false)
                    }
                    TextButton(
                        onClick = { recurrenceMenuOpened = true }, shape = Shapes.large
                    ) {
                        Text(state.recurrence?.name ?: Recurrence.None.name)
                        DropdownMenu(expanded = recurrenceMenuOpened,
                            onDismissRequest = { recurrenceMenuOpened = false }) {
                            recurrences.forEach { recurrence ->
                                DropdownMenuItem(text = { Text(recurrence.name) }, onClick = {
                                    vm.setRecurrence(recurrence)
                                    recurrenceMenuOpened = false
                                })
                            }
                        }
                    }
                })

                Divider(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp
                        ),
                    thickness = 1.dp,
                    color = DividerColor
                )
                var datePickerShowing by remember {
                    mutableStateOf(false)
                }
                TableRow(label = "Date", detailContent = {
                    TextButton(onClick = { datePickerShowing = true }) {
                        Text(state.date.toString())
                    }
                    if (datePickerShowing) {
                        DatePickerDialog(
                            onDismissRequest = { datePickerShowing = false },
                            onDateChange = { it ->
                                vm.setDate(it)
                                datePickerShowing = false
                            },
                            initialDate = state.date,
                            title = { Text("Select a Date", style = Typography.titleLarge) },
                        )
                    }
                })

                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
                TableRow(label = "Note", detailContent = {
                    UnstyledTextField(
                        value = state.note,
                        onValueChange = vm::setNote,
                        placeholder = { Text("Leave some notes") },
                        modifier = Modifier.fillMaxWidth(),
                        arrangement = Arrangement.End,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                    )
                })

                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
                TableRow(label = "Category", detailContent = {
                    var categoriesMenuOpened by remember {
                        mutableStateOf(false)
                    }
                    TextButton(
                        onClick = { categoriesMenuOpened = true }, shape = Shapes.large
                    ) {// TODO:  change the color of the text based on the selected category
                        Text(state.category ?: "Select a category first")
                        DropdownMenu(expanded = categoriesMenuOpened,
                            onDismissRequest = { categoriesMenuOpened = false }) {
                            categories.forEach { category ->
                                DropdownMenuItem(text = {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Surface(
                                            modifier = Modifier.size(10.dp),
                                            shape = CircleShape,
                                            color = Primary, // TODO: change the color based on the category
                                        ) {}
                                        Text(
                                            category,
                                            modifier = Modifier.padding(start = 8.dp)
                                        )
                                    }
                                }, onClick = {
                                    vm.setCategory(category)
                                    categoriesMenuOpened = false
                                })
                            }
                        }
                    }
                })
            }
            Button(
                onClick = vm::submitExpense,
                modifier = Modifier.padding(16.dp),
                shape = Shapes.large,
            ) {
                Text("Submit Expenses")
            }
        }
    })
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAdd() {
    YourMoneyTheme {
        val navController = rememberNavController()
        Add(navController = navController)
    }
}