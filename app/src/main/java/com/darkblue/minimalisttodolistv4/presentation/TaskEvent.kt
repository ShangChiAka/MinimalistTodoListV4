package com.darkblue.minimalisttodolistv4.presentation

import com.darkblue.minimalisttodolistv4.data.RecurrenceType
import com.darkblue.minimalisttodolistv4.data.SortType
import com.darkblue.minimalisttodolistv4.data.Task

sealed interface TaskEvent {
    object SaveTask: TaskEvent
    data class SetTitle(val title: String): TaskEvent
    data class SetPriority(val priority: Int): TaskEvent
    data class SetNote(val note: String): TaskEvent
    data class SetDueDate(val dueDate: Long): TaskEvent
    data class SortTasks(val sortType: SortType): TaskEvent
    data class DeleteTask(val task: Task): TaskEvent

    object ShowDialog: TaskEvent
    object HideDialog: TaskEvent

    // Date Picker
    object ShowDatePicker: TaskEvent
    object HideDatePicker: TaskEvent

    data class SetRecurrenceType(val recurrenceType: RecurrenceType) : TaskEvent

    data class EditTask(val task: Task) : TaskEvent

//    object ShowAddTaskDialog: TaskEvent
//    object HideAddTaskDialog: TaskEvent
//    object ShowSettingsDialog: TaskEvent
//    object HideSettingsDialog: TaskEvent
}
