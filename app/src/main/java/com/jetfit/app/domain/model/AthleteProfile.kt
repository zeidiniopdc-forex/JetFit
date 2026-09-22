package com.jetfit.app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AthleteProfile(
    val id: Long = 0,
    val name: String = "",
    val age: Int? = null,
    val gender: String? = null,
    val heightCm: Double? = null,
    val weightKg: Double? = null,
    val experienceLevel: String? = null,
    val weeklyTrainingDays: Int = 0,
    val equipment: List<String> = emptyList(),
    val goals: List<String> = emptyList(),
    val limitations: List<String> = emptyList()
)
