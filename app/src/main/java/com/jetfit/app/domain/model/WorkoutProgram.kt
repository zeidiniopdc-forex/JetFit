package com.jetfit.app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutProgram(
    val programName: String,
    val duration: String,
    val days: List<WorkoutDay>
)

@Serializable
data class WorkoutDay(
    val day: String,
    val muscleGroups: List<String> = emptyList(),
    val exercises: List<Exercise> = emptyList()
)

@Serializable
data class Exercise(
    val name: String,
    val sets: String,
    val reps: String,
    val rest: String = "",
    val tempo: String = "",
    val notes: String = ""
)
