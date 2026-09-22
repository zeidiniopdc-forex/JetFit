package com.jetfit.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jetfit.app.core.ui.JetFitTheme
import com.jetfit.app.data.AthleteProfileRepository
import com.jetfit.app.presentation.profile.AthleteProfileScreen
import com.jetfit.app.presentation.profile.AthleteProfileViewModel
import com.jetfit.app.presentation.profile.AthleteProfileViewModelFactory

class MainActivity : ComponentActivity() {
    private val profileViewModel: AthleteProfileViewModel by viewModels {
        AthleteProfileViewModelFactory(
            AthleteProfileRepository((application as JetFitApplication).database.athleteProfileDao())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by profileViewModel.uiState.collectAsStateWithLifecycle()
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                JetFitTheme {
                    AthleteProfileScreen(
                        state = state,
                        onProfileChange = profileViewModel::updateProfile,
                        onSave = profileViewModel::save
                    )
                }
            }
        }
    }
}
