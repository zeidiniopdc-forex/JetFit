package com.jetfit.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetfit.app.data.AthleteProfileRepository
import com.jetfit.app.domain.model.AthleteProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AthleteProfileUiState(
    val profile: AthleteProfile = AthleteProfile(),
    val isSaving: Boolean = false,
    val saved: Boolean = false,
    val error: String? = null
)

class AthleteProfileViewModel(
    private val repository: AthleteProfileRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(AthleteProfileUiState())
    val uiState: StateFlow<AthleteProfileUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observe().collect { profile ->
                if (profile != null) _uiState.update { it.copy(profile = profile) }
            }
        }
    }

    fun updateProfile(profile: AthleteProfile) {
        _uiState.update { it.copy(profile = profile, saved = false, error = null) }
    }

    fun save() {
        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, saved = false, error = null) }
            runCatching { repository.save(_uiState.value.profile) }
                .onSuccess { _uiState.update { it.copy(isSaving = false, saved = true) } }
                .onFailure { error ->
                    _uiState.update {
                        it.copy(isSaving = false, error = error.message ?: "ذخیره‌سازی ناموفق بود")
                    }
                }
        }
    }
}
