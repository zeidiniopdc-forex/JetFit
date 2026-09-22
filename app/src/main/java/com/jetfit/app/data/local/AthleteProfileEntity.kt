package com.jetfit.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "athlete_profiles")
data class AthleteProfileEntity(
    @PrimaryKey val id: Long = 1,
    val name: String,
    val age: Int?,
    val heightCm: Double?,
    val weightKg: Double?,
    val experienceLevel: String?,
    val weeklyTrainingDays: Int,
    val goalsJson: String,
    val limitationsJson: String
)
