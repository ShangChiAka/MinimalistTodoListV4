package com.darkblue.minimalisttodolistv4.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import com.maxkeppeler.sheets.date_time.DateTimeDialog
import com.maxkeppeler.sheets.date_time.models.DateTimeSelection
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePicker(modifier: Modifier = Modifier, onDateSelected: (LocalDate) -> Unit, closeSelection: () -> Unit) {
    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }
    val state = rememberUseCaseState(visible = true, onCloseRequest = { closeSelection() })

    CalendarDialog(
        state = state,
        config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.MONTH,
        ),
        selection = CalendarSelection.Date { newDate ->
            selectedDate.value = newDate
            onDateSelected(newDate)
//            closeSelection()
        },
    )
}
//fun DatePicker(modifier: Modifier = Modifier, closeSelection: () -> Unit, ) {
//    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }
////    CustomBox {
//        CalendarDialog(
//            state = rememberUseCaseState(visible = true, onCloseRequest = { closeSelection() }),
//            config = CalendarConfig(
//                yearSelection = true,
//                monthSelection = true,
//                style = CalendarStyle.MONTH,
//            ),
//            selection = CalendarSelection.Date { newDate ->
//                selectedDate.value = newDate
//            },
//        )
////    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePicker(modifier: Modifier = Modifier, closeSelection: () -> Unit) {
    val selectedTime = remember { mutableStateOf(LocalTime.of(8, 20, 0)) }
    ClockDialog(
        state = rememberUseCaseState(visible = true, onCloseRequest = { closeSelection() }),
        selection = ClockSelection.HoursMinutes { hours, minutes ->
            selectedTime.value = LocalTime.of(hours, minutes, 0)
        },
        config = ClockConfig(
            boundary = LocalTime.of(0, 0, 0)..LocalTime.of(12, 59, 0),
            defaultTime = selectedTime.value,
            is24HourFormat = false
        ),
    )
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun DatePicker(onDateSelected: (LocalDate) -> Unit) {
//    val context = LocalContext.current
//    val today = LocalDate.now()
//
//    // A state to trigger the dialog
//    var showDialog by remember { mutableStateOf(true) }
//
//    if (showDialog) {
//        val datePickerDialog = android.app.DatePickerDialog(
//            context,
//            { _, year, month, dayOfMonth ->
//                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
//                onDateSelected(selectedDate)
//                showDialog = false // Close the dialog
//            },
//            today.year, today.monthValue - 1, today.dayOfMonth
//        )
//
//        // Show the date picker dialog
//        LaunchedEffect(Unit) {
//            datePickerDialog.show()
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DatePicker(onClickAction: () -> Unit) {
//    val state = rememberDatePickerState()
//    val openDialog = remember { mutableStateOf(true) }
//
//    if (openDialog.value) {
//        DatePickerDialog(
//            modifier = Modifier
//                .clip(shape = RoundedCornerShape(percent = 7)),
//            colors = DatePickerDefaults.colors(
//                containerColor = Color.Black,
//            ),
//            onDismissRequest = {
//                openDialog.value = false
////                viewModel.setDate("")
//                onClickAction.invoke()
//            },
//            confirmButton = {
//            },
//            dismissButton = {
//            },
//        ) {
//            Box(
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .clip(shape = RoundedCornerShape(percent = 7))
//                    .background(Color.Black)
//                    .fillMaxWidth()
////                    .size(width = 500.dp, height = 700.dp)
//                    .padding(start = 4.dp, end = 4.dp)
//                    .border(
//                        width = 2.dp,
//                        color = Color.White,
//                        shape = RoundedCornerShape(percent = 7)
//                    )
//                ,
//            ) {
//                Column (
//                    modifier = Modifier,
//
//                    ) {
//                    androidx.compose.material3.DatePicker(
//                        modifier = Modifier
////                            .size(100.dp)
////                            .align(Alignment.Start)
////                            .background(Color.Yellow)
//                        ,
//                        state = state,
//                        showModeToggle = false,
//                        colors = DatePickerDefaults.colors(
//                            containerColor = Color.Black,
//                            titleContentColor = Color.White,
//                            headlineContentColor = Color.White,
//                            weekdayContentColor = Color.White,
//                            subheadContentColor = Color.White,
//
//                            yearContentColor = Color.White,
//                            currentYearContentColor = Color.White,
//                            selectedYearContentColor = Color.Black,
//                            selectedYearContainerColor = Color.White,
//
//                            dayContentColor = Color.White,
//                            disabledDayContentColor = Color.White,
//                            selectedDayContentColor = Color.Black,
//                            disabledSelectedDayContentColor = Color.White,
//                            selectedDayContainerColor = Color.White,
//                            disabledSelectedDayContainerColor = Color.White,
//
//                            todayContentColor = Color.White,
//                            todayDateBorderColor = Color.White,
//
//                            dayInSelectionRangeContentColor = Color.White,
//                            dayInSelectionRangeContainerColor = Color.White,
//
//                            )
//                    )
//                    Row(
//                        modifier = Modifier
//                            .background(Color.Black)
//                            .fillMaxWidth()
//                            .size(100.dp)
//                            .padding(bottom = 20.dp, end = 20.dp)
//                        ,
//                        horizontalArrangement = Arrangement.End
//                    ){
//                        TextButton(
//                            onClick = {
//                                openDialog.value = false
////                                viewModel.setDate("")
//                                onClickAction.invoke()
//                            }
//                        ) {
//                            Text("CANCEL", color = Color.White)
//                        }
//                        TextButton(
//                            onClick = {
//                                openDialog.value = false
//                                onClickAction.invoke()
//                            }
//                        ) {
//                            Text("OK", color = Color.White)
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//////    viewModel.setDate(state.selectedDateMillis?.let { viewModel.convertMillisToDate(it) }.toString())
//////    if(state.selectedDateMillis != null) Log.d("MYTAG", state.selectedDateMillis.toString())
////    if(state.selectedDateMillis != null) viewModel.setDate(state.selectedDateMillis.toString())
//}
