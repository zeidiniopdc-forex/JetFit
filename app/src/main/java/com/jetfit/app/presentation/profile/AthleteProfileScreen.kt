package com.jetfit.app.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jetfit.app.domain.model.AthleteProfile

@Composable
fun AthleteProfileScreen(
    state: AthleteProfileUiState,
    onProfileChange: (AthleteProfile) -> Unit,
    onSave: () -> Unit
) {
    var name by remember(state.profile.name) { mutableStateOf(state.profile.name) }
    var age by remember(state.profile.age) { mutableStateOf(state.profile.age?.toString().orEmpty()) }
    var height by remember(state.profile.heightCm) { mutableStateOf(state.profile.heightCm?.toString().orEmpty()) }
    var weight by remember(state.profile.weightKg) { mutableStateOf(state.profile.weightKg?.toString().orEmpty()) }
    var days by remember(state.profile.weeklyTrainingDays) { mutableStateOf(state.profile.weeklyTrainingDays.toString()) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("پروفایل ورزشکار")
        OutlinedTextField(name, { name = it }, Modifier.fillMaxWidth(), label = { Text("نام و نام خانوادگی") }, singleLine = true)
        OutlinedTextField(age, { age = it }, Modifier.fillMaxWidth(), label = { Text("سن") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), singleLine = true)
        OutlinedTextField(height, { height = it }, Modifier.fillMaxWidth(), label = { Text("قد (سانتی‌متر)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), singleLine = true)
        OutlinedTextField(weight, { weight = it }, Modifier.fillMaxWidth(), label = { Text("وزن (کیلوگرم)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), singleLine = true)
        OutlinedTextField(days, { days = it }, Modifier.fillMaxWidth(), label = { Text("روزهای تمرین در هفته") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), singleLine = true)
        state.error?.let { Text(it) }
        if (state.saved) Text("پروفایل با موفقیت ذخیره شد")
        Button(
            onClick = {
                onProfileChange(
                    state.profile.copy(
                        name = name.trim(),
                        age = age.toIntOrNull(),
                        heightCm = height.toDoubleOrNull(),
                        weightKg = weight.toDoubleOrNull(),
                        weeklyTrainingDays = days.toIntOrNull() ?: 0
                    )
                )
                onSave()
            },
            enabled = !state.isSaving,
            modifier = Modifier.fillMaxWidth()
        ) { Text(if (state.isSaving) "در حال ذخیره…" else "ذخیره پروفایل") }
    }
}
