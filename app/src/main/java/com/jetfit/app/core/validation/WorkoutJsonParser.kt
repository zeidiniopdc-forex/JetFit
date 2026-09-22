package com.jetfit.app.core.validation

import com.jetfit.app.domain.model.WorkoutProgram
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

sealed interface WorkoutJsonResult {
    data class Success(val program: WorkoutProgram) : WorkoutJsonResult
    data class Error(val message: String) : WorkoutJsonResult
}

class WorkoutJsonParser(
    private val json: Json = Json { ignoreUnknownKeys = false; isLenient = false }
) {
    fun parse(rawJson: String): WorkoutJsonResult = try {
        if (rawJson.isBlank()) return WorkoutJsonResult.Error("متن JSON خالی است")
        WorkoutJsonResult.Success(json.decodeFromString<WorkoutProgram>(rawJson))
    } catch (_: SerializationException) {
        WorkoutJsonResult.Error("ساختار JSON برنامه تمرینی معتبر نیست")
    } catch (_: IllegalArgumentException) {
        WorkoutJsonResult.Error("JSON واردشده قابل خواندن نیست")
    }
}
