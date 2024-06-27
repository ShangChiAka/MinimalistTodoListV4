package com.darkblue.minimalisttodolistv4.presentation

import com.darkblue.minimalisttodolistv4.data.RecurrenceType
import com.darkblue.minimalisttodolistv4.data.SortType
import com.darkblue.minimalisttodolistv4.data.Task
import java.time.LocalDate
import java.time.LocalTime

data class TaskState(
    val tasks: List<Task> = emptyList(),
    val title: String = "",
    val priority: Int = 0,
    val note: String = "",
    val sortType: SortType = SortType.PRIORITY,

    val isDatePickerVisible: Boolean = false,
    val isTimePickerVisible: Boolean = false,
    val isAddTaskDialogVisible: Boolean = false,
    val isMenuDialogVisible: Boolean = false,
    val isHistoryDialogVisible: Boolean = false,

    val recurrenceType: RecurrenceType = RecurrenceType.NONE,
    val recurrenceFilter: RecurrenceType = RecurrenceType.NONE,
    val nextDueDate: Long? = null,

    val dueDate: Long? = null,
    val dueDateOnly: LocalDate? = null,
    val dueTimeOnly: LocalTime? = null,

    val editingTaskId: Int? = null,
)
