package com.jetfit.app.data.local

import com.jetfit.app.domain.model.AthleteProfile
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AthleteProfileMapper(private val json: Json = Json) {
    fun toEntity(profile: AthleteProfile): AthleteProfileEntity = AthleteProfileEntity(
        id = if (profile.id == 0L) 1L else profile.id,
        name = profile.name,
        age = profile.age,
        heightCm = profile.heightCm,
        weightKg = profile.weightKg,
        experienceLevel = profile.experienceLevel,
        weeklyTrainingDays = profile.weeklyTrainingDays,
        goalsJson = json.encodeToString(profile.goals),
        limitationsJson = json.encodeToString(profile.limitations)
    )

    fun toDomain(entity: AthleteProfileEntity): AthleteProfile = AthleteProfile(
        id = entity.id,
        name = entity.name,
        age = entity.age,
        heightCm = entity.heightCm,
        weightKg = entity.weightKg,
        experienceLevel = entity.experienceLevel,
        weeklyTrainingDays = entity.weeklyTrainingDays,
        goals = json.decodeFromString(entity.goalsJson),
        limitations = json.decodeFromString(entity.limitationsJson)
    )
}
