package com.jetfit.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetfit.app.data.AthleteProfileRepository

class AthleteProfileViewModelFactory(
    private val repository: AthleteProfileRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(AthleteProfileViewModel::class.java))
        return AthleteProfileViewModel(repository) as T
    }
}
