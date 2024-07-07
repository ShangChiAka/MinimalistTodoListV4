package com.darkblue.minimalisttodolistv4.viewmodel

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.darkblue.minimalisttodolistv4.data.preferences.AppPreferences
import com.darkblue.minimalisttodolistv4.util.PermissionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(private val appPreferences: AppPreferences) : ViewModel() {
    private val _state = MutableStateFlow(AppState())
    val state: StateFlow<AppState> = _state

    private lateinit var permissionManager: PermissionManager

    fun setPermissionManager(permissionManager: PermissionManager) {
        this.permissionManager = permissionManager
    }

    fun onEvent(event: AppEvent) {
        when (event) {
            AppEvent.ShowMenuDialog -> updateState { copy(isMenuDialogVisible = true) }
            AppEvent.HideMenuDialog -> updateState { copy(isMenuDialogVisible = false) }

            AppEvent.ShowHistoryDialog -> updateState {
                copy(isHistoryDialogVisible = true, isMenuDialogVisible = false)
            }
            AppEvent.HideHistoryDialog -> updateState { copy(isHistoryDialogVisible = false) }

            AppEvent.ShowFontSettingsDialog -> updateState {
                copy(isFontSettingsDialogVisible = true, isMenuDialogVisible = false)
            }
            AppEvent.HideFontSettingsDialog -> updateState { copy(isFontSettingsDialogVisible = false) }

            AppEvent.ShowScheduleExactAlarmPermissionDialog -> updateState {
                copy(isScheduleExactAlarmPermissionDialogVisible = true)
            }
            AppEvent.HideScheduleExactAlarmPermissionDialog -> updateState {
                copy(isScheduleExactAlarmPermissionDialogVisible = false)
            }

            AppEvent.ShowScheduleExactAlarmPermissionIntent -> {
                permissionManager.requestScheduleExactAlarmPermission()
            }
            AppEvent.CheckNotificationPermissions -> {
                viewModelScope.launch { permissionManager.requestPermissions() }
            }
            AppEvent.IncrementPostNotificationDenialCount -> {
                viewModelScope.launch { appPreferences.incrementPostNotificationDenialCount() }
            }

            AppEvent.ShowTutorialDialog -> updateState { copy(isTutorialDialogVisible = true) }
            AppEvent.HideTutorialDialog -> updateState { copy(isTutorialDialogVisible = false) }
        }
    }

    private inline fun updateState(update: AppState.() -> AppState) {
        _state.update { it.update() }
    }
}

class AppViewModelFactory(private val appPreferences: AppPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppViewModel(appPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
